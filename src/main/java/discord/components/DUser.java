package discord.components;

import org.javacord.api.entity.user.User;

public class DUser
{
    private User user;

    public DUser(User user)
    {
        this.user = user;
    }

    public void addRole(DRole role)
    {
        user.addRole(role.getRole());
    }
}