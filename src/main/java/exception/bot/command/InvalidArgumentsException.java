package exception.bot.command;

import java.awt.Color;

/**
 * Thrown when invalid arguments are provided to a command
 */
public class InvalidArgumentsException extends CommandException
{
    /**
     * Constructs with a message and a yellow color
     *
     * @param message the details of the exception
     */
    public InvalidArgumentsException(String message)
    {
        super(message, Color.YELLOW);
    }
}