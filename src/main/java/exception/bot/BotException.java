package exception.bot;

import exception.ManaphyException;

import java.awt.*;

public class BotException extends ManaphyException
{
    public BotException(String message)
    {
        super(message);
    }

    public BotException(String message, Color color)
    {
        super(message, color);
    }
}