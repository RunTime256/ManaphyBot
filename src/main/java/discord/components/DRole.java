package discord.components;

import org.javacord.api.entity.permission.Role;

public class DRole
{
    private Role role;

    public DRole(Role role)
    {
        this.role = role;
    }

    public long getID()
    {
        return role.getId();
    }

    Role getRole()
    {
        return role;
    }
}