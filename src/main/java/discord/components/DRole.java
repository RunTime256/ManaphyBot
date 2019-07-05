package discord.components;

import org.javacord.api.entity.permission.Role;

public class DRole
{
    private Role role;

    public DRole(Role role)
    {
        this.role = role;
    }

    public long getId()
    {
        return role.getId();
    }

    public Role getRole()
    {
        return role;
    }

    public boolean hasRole(DUser user)
    {
        return role.getUsers().contains(user.getUser());
    }
}