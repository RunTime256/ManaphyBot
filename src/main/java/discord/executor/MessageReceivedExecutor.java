package discord.executor;

import discord.components.DCategory;
import discord.components.DChannel;
import discord.components.DGuild;
import discord.components.functionality.command.MessageCommand;
import discord.components.functionality.command.RoleCheck;
import discord.components.functionality.command.RoleRequirement;
import discord.components.functionality.verification.MessageVerifier;
import discord.guilds.Guild;
import discord.io.event.MessageReceivedEvent;
import discord.io.response.ErrorResponse;
import discord.roles.Role;
import discord.whiteblacklist.WhiteBlackList;
import exception.bot.BotException;
import exception.bot.command.help.NoHelpException;
import exception.bot.command.CommandException;
import exception.bot.command.InvalidArgumentsException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Runs commands
 */
public class MessageReceivedExecutor
{
    private Map<String, MessageCommand> commands;
    private String prefix;

    /**
     * Constructs with prefix
     *
     * @param prefix bot prefix
     */
    public MessageReceivedExecutor(String prefix)
    {
        commands = new HashMap<>();
        this.prefix = prefix;
    }

    public void addCommand(MessageCommand command)
    {
        commands.put(command.getName(), command);
    }

    /**
     * Executes command
     *
     * @param event message received event
     */
    public void execute(MessageReceivedEvent event)
    {
        List<String> content = event.getMessage().getSplitContent();
        if (content.isEmpty() || !RoleCheck.checkRole(event.getApi(), event.getAuthor().getId(), RoleRequirement.VERIFIED))
            return;

        MessageCommand command = getCommand(content);
        String message = combineContent(content);

        RoleRequirement requirement;
        if (command != null && checkWhiteBlackList(command.getFullName(), event) &&
                ((requirement = command.getRequirement()) == null || RoleCheck.checkRole(event.getApi(), event.getAuthor().getId(), requirement)))
        {
            try
            {
                tryExecute(command, message, content, event);
            }
            catch (Exception e)
            {
                sendErrorMessage(e, event.getChannel());
            }
        }
    }

    /**
     * Executes secret command
     *
     * @param event message received event
     * @return if a secret command was executed or not
     */
    public boolean secretExecute(MessageReceivedEvent event)
    {
        List<String> content = event.getMessage().getSplitContent();
        if (content.isEmpty())
            return false;

        MessageCommand command = getCommand(content);
        String message = combineContent(content);

        if (command != null && checkWhiteBlackList(command.getFullName(), event))
        {
            try
            {
                command.execute(message, event);
                return true;
            }
            catch (InvalidArgumentsException ignored)
            {
            }
            catch (Exception e)
            {
                sendErrorMessage(e, event.getChannel());
            }
        }
        return false;
    }

    /**
     * Checks whitelist and blacklist to see if the command can be run in its current location
     *
     * @param commandName name of command
     * @param event message received event
     * @return if the command can be executed
     */
    private boolean checkWhiteBlackList(String commandName, MessageReceivedEvent event)
    {
        WhiteBlackList whiteBlackList = new WhiteBlackList();
        if (event.isDM())
        {
            return whiteBlackList.isAllowedDM(commandName);
        }

        if (event.isServerMessage())
        {
            long guildId = event.getGuild().getId();
            long channelId = event.getChannel().getId();
            DCategory category = event.getChannel().getCategory();
            if (category != null)
                return whiteBlackList.isAllowed(commandName, guildId, category.getId(), channelId);
            else
                return whiteBlackList.isAllowed(commandName, guildId, channelId);

        }

        return true;
    }


    /**
     * Tries to execute command, and sends help message if there is an invalid argument
     *
     * @param command command to execute
     * @param message message to get arguments from
     * @param content split message content
     * @param event message received event
     * @throws BotException if an exception was thrown from the bot
     */
    private void tryExecute(MessageCommand command, String message, List<String> content, MessageReceivedEvent event) throws BotException
    {
        try
        {
            command.execute(message, event);
        }
        catch (InvalidArgumentsException e)
        {
            sendHelpMessage(getCommandSequence(event.getMessage().getSplitContent(), content.size()), event, e);
        }
    }

    /**
     * Sends error message
     *
     * @param exception exception thrown
     * @param channel channel to send response to
     */
    private void sendErrorMessage(Exception exception, DChannel channel)
    {
        ErrorResponse response = new ErrorResponse(exception, channel);
        response.sendErrorMessage();
    }

    /**
     * Sends help message
     *
     * @param commandSequence sequence of commands ran
     * @param event message received event
     * @param exception exception thrown
     * @throws CommandException if there was an issue running the help command
     */
    private void sendHelpMessage(String commandSequence, MessageReceivedEvent event, InvalidArgumentsException exception) throws CommandException
    {
        if (!checkWhiteBlackList("help", event))
            return;

        MessageCommand help = commands.get("help");
        if (help == null)
            throw new NoHelpException("There was an error formatting your command, and no help implementation was available. " +
                    "Please refer to any previous announcements on how to format the command correctly.");

        String errorCommand;
        if (exception.getMessage().isEmpty())
            errorCommand = commandSequence;
        else
            errorCommand = commandSequence + " " + MessageVerifier.ARGUMENT + "e " + exception.getMessage();

        help.execute(errorCommand, event);
    }

    private String getCommandSequence(List<String> original, int remove)
    {
        List<String> commandSequence = new ArrayList<>();
        if (!original.isEmpty())
            commandSequence.add(removePrefix(original.get(0)));

        for (int i = 1; i < original.size() - remove; i++)
            commandSequence.add(original.get(i));

        return combineContent(commandSequence);
    }

    private MessageCommand getCommand(List<String> content)
    {
        String firstCommand = content.remove(0);
        if (firstCommand.startsWith(prefix))
            firstCommand = removePrefix(firstCommand);
        else
            return null;

        if (!hasCommand(firstCommand))
            return null;

        MessageCommand currentCommand = commands.get(firstCommand);
        while (!content.isEmpty())
        {
            String subCommand = content.get(0);

            if (subCommand.equals(""))
            {
                content.remove(0);
            }
            else if (currentCommand.hasSubCommand(subCommand))
            {
                currentCommand = currentCommand.getSubCommand(subCommand);
                content.remove(0);
            }
            else
                break;
        }

        return currentCommand;
    }

    private boolean hasCommand(String name)
    {
        return commands.containsKey(name);
    }

    private String removePrefix(String command)
    {
        if (command.length() <= prefix.length())
            return "";
        else
            return command.substring(prefix.length());
    }

    private String combineContent(List<String> messageContent)
    {
        StringBuilder builder = new StringBuilder();
        for (String portion: messageContent)
        {
            String text = portion + " ";
            builder.append(text);
        }

        if (builder.length() > 0)
            builder.deleteCharAt(builder.length() - 1);

        return builder.toString();
    }
}