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
}