package bot.command.help;

import bot.command.help.verifier.HelpContent;
import bot.command.help.verifier.HelpVerifier;
import discord.builder.DEmbedBuilder;
import discord.components.functionality.command.MessageCommand;
import discord.components.functionality.verification.VerifiedMessage;
import discord.io.response.MessageResponse;

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
        MessageCommand command = content.getCommand();
        String exception = content.getException();
        MessageResponse sender = content.getSender();

        DEmbedBuilder builder = buildHelp(command, exception);
        sender.sendMessage(builder);
    }

    private DEmbedBuilder buildHelp(MessageCommand command, String exception)
    {
        DEmbedBuilder builder = new DEmbedBuilder();

        return builder;
    }
}