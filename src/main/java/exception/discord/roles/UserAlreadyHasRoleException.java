package exception.discord.roles;

/**
 * Thrown when a user already has a role
 */
public class UserAlreadyHasRoleException extends RoleException
{
    /**
     * Constructs with a message
     *
     * @param message the details of the exception
     */
    public UserAlreadyHasRoleException(String message)
    {
        super(message);
    }
}