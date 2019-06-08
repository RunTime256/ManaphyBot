package exception.discord;

import exception.ManaphyException;

import java.awt.Color;

public class DiscordException extends ManaphyException
{
    public DiscordException(String message)
    {
        super(message, Color.BLUE);
    }
}