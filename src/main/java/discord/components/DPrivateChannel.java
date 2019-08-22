package discord.components;

import discord.builder.DEmbedBuilder;
import discord.builder.DMessageBuilder;
import org.javacord.api.entity.channel.PrivateChannel;

import java.util.Optional;

/**
 * Wrapper for Discord channels
 */
public class DPrivateChannel
{
    private PrivateChannel channel;

    public DPrivateChannel(PrivateChannel channel)
    {
        this.channel = channel;
    }

    public long getId()
    {
        return channel.getId();
    }

    public DMessage sendMessage(String message)
    {
        return new DMessage(channel.sendMessage(message).join());
    }

    public DMessage sendMessage(DEmbedBuilder builder)
    {
        return new DMessage(channel.sendMessage(builder.getBuilder()).join());
    }

    public DMessage sendMessage(DMessageBuilder builder)
    {
        return new DMessage(builder.getBuilder().send(channel).join());
    }
}