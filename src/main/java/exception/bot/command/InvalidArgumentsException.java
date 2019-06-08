package exception.bot.command;

import java.awt.*;

public class InvalidArgumentsException extends CommandException
{
    public InvalidArgumentsException(String message)
    {
        super(message, Color.YELLOW);
    }
}