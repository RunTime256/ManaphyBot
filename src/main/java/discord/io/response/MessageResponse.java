package discord.io.response;

import discord.builder.DEmbedBuilder;
import discord.components.DChannel;
import discord.components.DMessage;

public class MessageResponse
{
    private DChannel channel;

    public MessageResponse(DChannel channel)
    {
        this.channel = channel;
    }

    public DMessage sendMessage(String message)
    {
        return channel.sendMessage(message);
    }

    public DMessage sendMessage(int x)
    {
        return channel.sendMessage(String.valueOf(x));
    }

    public DMessage sendMessage(DEmbedBuilder builder)
    {
        return channel.sendMessage(builder);
    }
}