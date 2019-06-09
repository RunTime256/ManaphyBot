package exception.bot;

import exception.ManaphyException;

import java.awt.Color;

public class NoHelpException extends ManaphyException
{
    public NoHelpException(String message)
    {
        super(message, Color.YELLOW);
    }
}