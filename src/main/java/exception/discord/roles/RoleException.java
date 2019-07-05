package exception.discord.roles;

import exception.discord.DiscordException;

public class RoleException extends DiscordException
{
    public RoleException(String message)
    {
        super(message);
    }
}