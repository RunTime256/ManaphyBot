package exception.bot;

import exception.ManaphyException;

import java.awt.Color;

/**
 * Thrown when an exception occurs in the bot
 */
public class BotException extends ManaphyException
{
    /**
     * Constructs with a message
     *
     * @param message the details of the exception
     */
    public BotException(String message)
    {
        super(message);
    }

    /**
     * Constructs with a message and color
     *
     * @param message the details of the exception
     * @param color the severity color
     */
    public BotException(String message, Color color)
    {
        super(message, color);
    }
}