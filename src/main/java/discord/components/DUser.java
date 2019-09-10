package discord.components;

import org.javacord.api.entity.user.User;

/**
 * Wrapper for Discord users
 */
public class DUser
{
    private User user;

    public DUser(User user)
    {
        this.user = user;
    }

    public User getUser()
    {
        return user;
    }

    public void addRole(DRole role)
    {
        user.addRole(role.getRole());
    }

    public void removeRole(DRole role)
    {
        user.removeRole(role.getRole());
    }

    public boolean hasRole(DRole role)
    {
        return role.hasRole(this);
    }

    public long getId()
    {
        return user.getId();
    }

    public String getMention()
    {
        return user.getMentionTag();
    }

    public String getName()
    {
        return user.getName();
    }

    public String getFullName()
    {
        return user.getDiscriminatedName();
    }

    public String getAvatar()
    {
        return user.getAvatar().getUrl().toString();
    }

    public DPrivateChannel getDM()
    {
        return new DPrivateChannel(user.openPrivateChannel().join());
    }
}