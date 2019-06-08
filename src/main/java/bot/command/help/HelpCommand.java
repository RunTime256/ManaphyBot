package bot.command.help;

import bot.command.help.verifier.HelpContent;
import bot.command.help.verifier.HelpVerifier;
import discord.components.functionality.command.MessageCommand;
import discord.components.functionality.verification.VerifiedMessage;

public class HelpCommand
{
    private MessageCommand command;

    public HelpCommand()
    {
        command = createHelpCommand();
    }

    public MessageCommand getCommand()
    {
        return command;
    }

    private MessageCommand createHelpCommand()
    {
        return new MessageCommand("help", "Get help with a command", (this::help), new HelpVerifier());
    }

    private void help(VerifiedMessage<HelpContent> message)
    {

    }
}