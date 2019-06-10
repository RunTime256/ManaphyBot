package bot.command.help;

import bot.command.help.verifier.HelpContent;
import bot.command.help.verifier.HelpVerifier;
import discord.builder.DEmbedBuilder;
import discord.components.functionality.command.MessageCommand;
import discord.components.functionality.verification.VerifiedMessage;
import discord.io.response.MessageResponse;
import util.Pair;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HelpCommand
{
    private Map<String, MessageCommand> executor;
    private MessageCommand command;

    public HelpCommand(List<MessageCommand> executor)
    {
        this.executor = new HashMap<>();
        for (MessageCommand command: executor)
            this.executor.put(command.getName(), command);

        this.command = createHelpCommand();
    }

    public MessageCommand getCommand()
    {
        return command;
    }

    private MessageCommand createHelpCommand()
    {
        return new MessageCommand("help", "Get help with a command", (this::help), new HelpVerifier(executor));
    }

    private void help(VerifiedMessage<HelpContent> message)
    {
        HelpContent content = message.getContent();
        String commandString = content.getCommandString();
        MessageCommand command = content.getCommand();
        String exception = content.getException();
        MessageResponse sender = content.getSender();

        DEmbedBuilder builder = buildHelp(commandString, command, exception);
        sender.sendMessage(builder);
    }

    private DEmbedBuilder buildHelp(String commandString, MessageCommand command, String exception)
    {
        DEmbedBuilder builder = new DEmbedBuilder();
        String author = "Help with Manaphy";
        String title = commandString;
        String description = command.getDescription();
        List<Pair<String, String>> subCommands = getSubCommands(command);
        String footer = exception;
        Color color = new Color(97, 185, 221);

        builder.setAuthor(author).setTitle(title).setColor(color);
        if (!footer.isEmpty())
            builder.setFooter(footer);
        if (!description.isEmpty())
            builder.setDescription(description);
        for (Pair<String, String> subCommand: subCommands)
            builder.addField(subCommand.getA(), subCommand.getB());

        return builder;
    }

    private List<Pair<String, String>> getSubCommands(MessageCommand command)
    {
        List<Pair<String, String>> pairs = new ArrayList<>();
        List<String> subCommands = command.getSubCommands();

        for (String subCommand: subCommands)
        {
            pairs.add(new Pair<>(subCommand, command.getSubCommand(subCommand).getName()));
        }

        return pairs;
    }
}