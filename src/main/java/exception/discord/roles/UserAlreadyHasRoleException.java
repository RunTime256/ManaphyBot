package exception.discord.roles;

public class UserAlreadyHasRoleException extends RoleException
{
    public UserAlreadyHasRoleException(String message)
    {
        super(message);
    }
}