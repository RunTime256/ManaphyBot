package exception.bot.command.help;

import exception.bot.command.CommandException;

import java.awt.Color;

/**
 * Thrown when there is no help implementation
 */
public class NoHelpException extends CommandException
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