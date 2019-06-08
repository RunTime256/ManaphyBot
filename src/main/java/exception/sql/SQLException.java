package exception.sql;

import exception.ManaphyException;

import java.awt.Color;

public class SQLException extends ManaphyException
{
    public SQLException(String message)
    {
        super(message, Color.GREEN);
    }
}