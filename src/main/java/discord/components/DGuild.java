package discord.components;

import org.javacord.api.entity.server.Server;

public class DGuild
{
    private Server guild;

    public DGuild(Server guild)
    {
        this.guild = guild;
    }

    public long getId()
    {
        return guild.getId();
    }
}