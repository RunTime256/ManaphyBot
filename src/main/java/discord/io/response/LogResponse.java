package discord.io.response;

import discord.builder.DEmbedBuilder;
import discord.components.DApi;
import discord.components.DChannel;
import discord.components.DGuild;

public class LogResponse
{
    private MessageResponse response;

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