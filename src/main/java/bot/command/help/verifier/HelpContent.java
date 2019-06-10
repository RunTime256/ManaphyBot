package bot.command.help.verifier;

import discord.components.functionality.command.MessageCommand;
import discord.io.response.MessageResponse;

public class HelpContent
{
    private String commandString;
    private MessageCommand command;
    private String exception;
    private MessageResponse sender;

    HelpContent(String commandString, MessageCommand command, String exception, MessageResponse sender)
    {
        this.commandString = commandString;
        this.command = command;
        this.exception = exception;
        this.sender = sender;
    }

    public String getCommandString()
    {
        return commandString;
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