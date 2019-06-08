package discord.io.response;

import discord.builder.DEmbedBuilder;
import discord.components.DChannel;

public class MessageResponse
{
    private DChannel channel;

    public MessageResponse(DChannel channel)
    {
        this.channel = channel;
    }

    public void sendMessage(String message)
    {
        channel.sendMessage(message);
    }

    public void sendMessage(int x)
    {
        channel.sendMessage(String.valueOf(x));
    }

    public void sendMessage(DEmbedBuilder builder)
    {
        channel.sendMessage(builder);
    }
}