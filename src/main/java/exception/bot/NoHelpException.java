package exception.bot;

import exception.ManaphyException;

import java.awt.Color;

/**
 * Thrown when there is no help implementation
 */
public class NoHelpException extends ManaphyException
{
    /**
     * Constructs with a message and a yellow color
     *
     * @param message the details of the exception
     */
    public NoHelpException(String message)
    {
        super(message, Color.YELLOW);
    }
}