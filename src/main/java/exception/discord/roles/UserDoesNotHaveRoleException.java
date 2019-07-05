package exception.discord.roles;

public class UserDoesNotHaveRoleException extends RoleException
{
    public UserDoesNotHaveRoleException(String message)
    {
        super(message);
    }
}