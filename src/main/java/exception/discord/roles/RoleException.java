package exception.discord.roles;

import exception.discord.DiscordException;

/**
 * Thrown when an exception occurs with roles
 */
public class RoleException extends DiscordException
{
    /**
     * Constructs with a message
     *
     * @param message the details of the exception
     */
    public RoleException(String message)
    {
        super(message);
    }
}