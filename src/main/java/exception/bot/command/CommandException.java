package exception.bot.command;

import exception.bot.BotException;

import java.awt.Color;

public class CommandException extends BotException
{
    public CommandException(String message)
    {
        super(message);
    }

    public CommandException(String message, Color color)
    {
        super(message, color);
    }
}