package discord.components;

import org.javacord.api.DiscordApi;
import org.javacord.api.entity.server.Server;
import org.javacord.api.entity.user.User;

import java.util.Optional;

/**
 * Wrapper for Discord api
 */
public class DApi
{
    private DiscordApi api;

    public DApi(DiscordApi api)
    {
        this.api = api;
    }

    public DGuild getGuildById(long id)
    {
        Optional<Server> guild = api.getServerById(id);
        if (guild.isPresent())
            return new DGuild(guild.get());
        else
            return null;
    }

    public DRole getRoleById(long guildId, long roleId)
    {
        DGuild guild = getGuildById(guildId);
        if (guild != null)
            return guild.getRoleById(roleId);
        else
            return null;
    }

    public DUser getUserById(long userId)
    {
        return new DUser(api.getUserById(userId).join());
    }

    public DUser getBot()
    {
        return new DUser(api.getYourself());
    }

    public DUser getOwner()
    {
        return new DUser(api.getOwner().join());
    }
}
