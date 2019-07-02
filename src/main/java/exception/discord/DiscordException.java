package exception.discord;

import exception.ManaphyException;

import java.awt.Color;

/**
 * Thrown when an exception occurs in Discord
 */
public class DiscordException extends ManaphyException
{
    /**
     * Constructs with a message and a blue color
     *
     * @param message the details of the exception
     */
    public DiscordException(String message)
    {
        super(message, Color.BLUE);
    }
}