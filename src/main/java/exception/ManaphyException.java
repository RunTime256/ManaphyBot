package exception;

import java.awt.Color;

/**
 * Thrown when an exception occurs within Manaphy
 */
public class ManaphyException extends Exception
{
    private final Color color;

    /**
     * Constructs with a message
     *
     * @param message the details of the exception
     */
    public ManaphyException(String message)
    {
        super(message);
        color = Color.RED;
    }

    /**
     * Constructs with a message and color
     *
     * @param message the details of the exception
     * @param color the severity color
     */
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