package exception;

import java.awt.Color;

public class ManaphyException extends Exception
{
    private Color color;

    public ManaphyException(String message)
    {
        super(message);
        color = Color.RED;
    }

    public ManaphyException(String message, Color color)
    {
        super(message);
        this.color = color;
    }

    public Color getColor()
    {
        return color;
    }
}