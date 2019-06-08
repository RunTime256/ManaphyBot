package discord.components;

import discord.builder.DEmbedBuilder;
import org.javacord.api.entity.channel.TextChannel;

public class DChannel
{
    private TextChannel channel;

    public DChannel(TextChannel channel)
    {
        this.channel = channel;
    }

    public void sendMessage(String message)
    {
        channel.sendMessage(message);
    }

    public void sendMessage(DEmbedBuilder builder)
    {
        channel.sendMessage(builder.getBuilder());
    }
}