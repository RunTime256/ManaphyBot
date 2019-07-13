package discord.components;

import org.javacord.api.entity.channel.ServerChannel;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.permission.Role;
import org.javacord.api.entity.server.Server;

import java.util.Optional;

/**
 * Wrapper for discord guilds
 */
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

    public DChannel getChannelById(long id)
    {
        Optional<ServerChannel> channel = guild.getChannelById(id);
        if (channel.isPresent())
        {
            Optional<TextChannel> textChannel = channel.get().asTextChannel();
            if (textChannel.isPresent())
                return new DChannel(textChannel.get());
        }

        return null;
    }

    public DRole getRoleById(long id)
    {
        Optional<Role> role = guild.getRoleById(id);
        if (role.isPresent())
            return new DRole(role.get());
        else
            return null;
    }
}