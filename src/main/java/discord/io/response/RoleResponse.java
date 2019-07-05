package discord.io.response;

import discord.components.DRole;
import discord.components.DUser;
import exception.discord.roles.UserAlreadyHasRoleException;
import exception.discord.roles.UserDoesNotHaveRoleException;

public class RoleResponse
{
    private DUser user;
    private DRole role;

    public RoleResponse(DUser user, DRole role)
    {
        this.user = user;
        this.role = role;
    }

    public void addRole() throws UserAlreadyHasRoleException
    {
        if (user.hasRole(role))
            throw new UserAlreadyHasRoleException(user.getId() + " already has role " + role.getId());

        user.addRole(role);
    }

    public void removeRole() throws UserDoesNotHaveRoleException
    {
        if (!user.hasRole(role))
            throw new UserDoesNotHaveRoleException(user.getId() + " does not have role " + role.getId());

        user.removeRole(role);
    }
}