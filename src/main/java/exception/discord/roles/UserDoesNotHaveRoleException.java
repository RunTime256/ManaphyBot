package exception.discord.roles;

/**
 * Thrown when a user does not have a role
 */
public class UserDoesNotHaveRoleException extends RoleException
{
    /**
     * Constructs with a message
     *
     * @param message the details of the exception
     */
    public UserDoesNotHaveRoleException(String message)
    {
        super(message);
    }
}