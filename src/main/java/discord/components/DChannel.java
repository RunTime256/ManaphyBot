package discord.components;

import discord.builder.DEmbedBuilder;
import org.javacord.api.entity.channel.ChannelCategory;
import org.javacord.api.entity.channel.ServerTextChannel;
import org.javacord.api.entity.channel.TextChannel;

import java.util.Optional;

public class DChannel
{
    private TextChannel channel;

    public DChannel(TextChannel channel)
    {
        this.channel = channel;
    }

    public long getId()
    {
        return channel.getId();
    }

    public DCategory getCategory()
    {
        Optional<ServerTextChannel> serverChannel = channel.asServerTextChannel();
        if (serverChannel.isPresent())
        {
            Optional<ChannelCategory> category = serverChannel.get().getCategory();
            if (category.isPresent())
                return new DCategory(category.get());
        }

        return null;
    }

    public DMessage sendMessage(String message)
    {
        return new DMessage(channel.sendMessage(message).join());
    }

    public DMessage sendMessage(DEmbedBuilder builder)
    {
        return new DMessage(channel.sendMessage(builder.getBuilder()).join());
    }
}