package discord.io.response;

import discord.builder.DEmbedBuilder;
import discord.builder.DMessageBuilder;
import discord.components.DChannel;
import discord.components.DMessage;

/**
 * Response creator for errors
 */
public class MessageResponse
{
    private DChannel channel;

    /**
     * Constructs with a channel
     *
     * @param channel channel to send response to
     */
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

    public DMessage sendMessage(DMessageBuilder builder)
    {
        return channel.sendMessage(builder);
    }
}