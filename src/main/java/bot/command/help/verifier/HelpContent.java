package bot.command.help.verifier;

import discord.components.functionality.command.MessageCommand;
import discord.io.response.MessageResponse;

public class HelpContent
{
    private MessageCommand command;
    private String exception;
    private MessageResponse sender;

    HelpContent(MessageCommand command, String exception, MessageResponse sender)
    {
        this.command = command;
        this.exception = exception;
        this.sender = sender;
    }

    public MessageCommand getCommand()
    {
        return command;
    }

    public String getException()
    {
        return exception;
    }

    public MessageResponse getSender()
    {
        return sender;
    }
}