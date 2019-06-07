package discord.components;

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
}