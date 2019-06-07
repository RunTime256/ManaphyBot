package discord.io.response;

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
}