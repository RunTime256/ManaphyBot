package exception.bot.command;

import exception.bot.BotException;

import java.awt.Color;

/**
 * Thrown when an exception occurs in a command
 */
public class CommandException extends BotException
{
    /**
     * Constructs with a message
     *
     * @param message the details of the exception
     */
    public CommandException(String message)
    {
        super(message);
    }


    /**
     * Constructs with a message and color
     *
     * @param message the details of the exception
     * @param color the severity color
     */
    public CommandException(String message, Color color)
    {
        super(message, color);
    }
}