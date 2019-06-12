package bot.command.help;

import bot.command.help.verifier.HelpContent;
import bot.command.help.verifier.HelpVerifier;
import discord.builder.DEmbedBuilder;
import discord.components.functionality.command.MessageCommand;
import discord.components.functionality.verification.VerifiedMessage;
import discord.io.response.MessageResponse;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HelpCommand
{
    private Map<String, MessageCommand> executor;
    private MessageCommand command;

    public HelpCommand(List<MessageCommand> executor, String prefix)
    {
        this.executor = new HashMap<>();
        for (MessageCommand command: executor)
            this.executor.put(command.getName(), command);

        this.command = createHelpCommand(prefix);
    }

    public MessageCommand getCommand()
    {
        return command;
    }

    private MessageCommand createHelpCommand(String prefix)
    {
        return new MessageCommand("help", "Get help with a command", (this::help), new HelpVerifier(executor, prefix));
    }

    private void help(VerifiedMessage<HelpContent> message)
    {
        HelpContent content = message.getContent();
        String prefix = content.getPrefix();
        String commandString = content.getCommandString();
        MessageCommand command = content.getCommand();
        String exception = content.getException();
        MessageResponse sender = content.getSender();

        DEmbedBuilder builder = buildHelp(prefix, commandString, command, exception);
        sender.sendMessage(builder);
    }

    private DEmbedBuilder buildHelp(String prefix, String commandString, MessageCommand command, String exception)
    {
        DEmbedBuilder builder = new DEmbedBuilder();
        String author = "Help with Manaphy";
        String description;
        if (command != null)
            description = combineSubCommands(prefix, commandString, command);
        else
            description = combineCommands(prefix);
        String footer = exception;
        Color color = new Color(97, 185, 221);

        builder.setAuthor(author).setColor(color);
        if (!footer.isEmpty())
            builder.setFooter(footer);
        builder.setDescription(description);

        return builder;
    }

    private String combineCommands(String prefix)
    {
        StringBuilder combined = new StringBuilder();

        combined.append("__**Commands:**__\n");

        for (String commandString: executor.keySet())
        {
            MessageCommand command = executor.get(commandString);
            String singleCommand = "**" + prefix + command.getName() + "** " + command.getDescription() + "\n\n";
            combined.append(singleCommand);
        }

        return combined.toString();
    }

    private String combineSubCommands(String prefix, String commandString, MessageCommand superCommand)
    {
        StringBuilder combined = new StringBuilder();

        String title = "`" + prefix + commandString + "`\n";
        combined.append(title);

        String desc = superCommand.getDescription();
        if (!desc.isEmpty())
        {
            combined.append(superCommand.getDescription());
            combined.append("\n");
        }

        StringBuilder subCommands = new StringBuilder();

        for (MessageCommand command : getSubCommands(superCommand))
        {
            String subCommand = "**" + prefix + commandString + " " + command.getName() + "** "
                    + command.getDescription() + "\n";
            subCommands.append(subCommand);
        }

        if (subCommands.length() > 0)
        {
            combined.append("\n__**Sub-commands:**__\n");
            combined.append(subCommands.toString());
        }

        return combined.toString();
    }

    private List<MessageCommand> getSubCommands(MessageCommand command)
    {
        List<MessageCommand> pairs = new ArrayList<>();
        List<String> subCommands = command.getSubCommands();

        for (String subCommand: subCommands)
        {
            pairs.add(command.getSubCommand(subCommand));
        }

        return pairs;
    }
}