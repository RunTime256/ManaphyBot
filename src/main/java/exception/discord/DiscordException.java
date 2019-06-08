package exception.discord;

import exception.ManaphyException;

import java.awt.*;

public class DiscordException extends ManaphyException
{
    public DiscordException(String message)
    {
        super(message, Color.BLUE);
    }
}