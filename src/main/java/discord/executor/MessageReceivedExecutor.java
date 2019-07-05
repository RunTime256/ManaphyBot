package discord.executor;

import discord.components.DCategory;
import discord.components.DChannel;
import discord.components.functionality.command.MessageCommand;
import discord.components.functionality.verification.MessageVerifier;
import discord.io.event.MessageReceivedEvent;
import discord.io.response.ErrorResponse;
import discord.whiteblacklist.WhiteBlackList;
import exception.bot.BotException;
import exception.bot.command.help.NoHelpException;
import exception.bot.command.CommandException;
import exception.bot.command.InvalidArgumentsException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageReceivedExecutor
{
    private Map<String, MessageCommand> commands;
    private String prefix;

    public MessageReceivedExecutor(String prefix)
    {
        commands = new HashMap<>();
        this.prefix = prefix;
    }

    public void addCommand(MessageCommand command)
    {
        commands.put(command.getName(), command);
    }

    public void execute(MessageReceivedEvent event)
    {
        List<String> content = event.getMessage().getSplitContent();
        if (content.isEmpty())
            return;

        MessageCommand command = getCommand(content);
        String message = combineContent(content);

        if (command != null && checkWhiteBlackList(command.getFullName(), event))
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

    private void sendErrorMessage(Exception e, DChannel channel)
    {
        ErrorResponse response = new ErrorResponse(e, channel);
        response.sendErrorMessage();
    }

    private void sendHelpMessage(String commandSequence, MessageReceivedEvent event, InvalidArgumentsException e) throws CommandException
    {
        MessageCommand help = commands.get("help");
        if (help == null)
            throw new NoHelpException("There was an error formatting your command, and no help implementation was available. " +
                    "Please refer to any previous announcements on how to format the command correctly.");

        String errorCommand;
        if (e.getMessage().isEmpty())
            errorCommand = commandSequence;
        else
            errorCommand = commandSequence + " " + MessageVerifier.ARGUMENT + "e " + e.getMessage();

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