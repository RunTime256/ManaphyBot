package discord.io.response;

import discord.builder.DEmbedBuilder;
import discord.components.DApi;
import discord.components.DChannel;
import discord.components.DGuild;

/**
 * Response creator for logs
 */
public class LogResponse
{
    private MessageResponse response;

    /**
     * Constructs with api, guild, and channel
     *
     * @param api Discord api
     * @param guildId id of log guild
     * @param channelId id of log channel
     */
    public LogResponse(DApi api, long guildId, long channelId)
    {
        DGuild guild = api.getGuildById(guildId);
        DChannel channel = null;
        if (guild != null)
            channel = guild.getChannelById(channelId);

        if (channel != null)
            response = new MessageResponse(channel);
        else
            response = null;
    }

    public void log(String message)
    {
        if (response != null)
            response.sendMessage(message);
    }

    public void log(int x)
    {
        if (response != null)
            response.sendMessage(String.valueOf(x));
    }

    public void log(DEmbedBuilder builder)
    {
        if (response != null)
            response.sendMessage(builder);
    }
}