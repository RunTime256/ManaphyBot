package exception.sql;

import exception.ManaphyException;

import java.awt.Color;

/**
 * Thrown when an exception occurs in SQL
 */
public class SQLException extends ManaphyException
{
    /**
     * Constructs with a message and a green color
     *
     * @param message the details of the exception
     */
    public SQLException(String message)
    {
        super(message, Color.GREEN);
    }
}