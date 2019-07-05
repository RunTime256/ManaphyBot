package discord.components;

import org.javacord.api.DiscordApi;
import org.javacord.api.entity.server.Server;

import java.util.Optional;

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

    public DUser getBot()
    {
        return new DUser(api.getYourself());
    }
}