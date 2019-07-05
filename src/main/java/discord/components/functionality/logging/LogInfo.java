package discord.components.functionality.logging;

public class LogInfo
{
    private long guildId;
    private long channelId;

    public LogInfo(long guildId, long channelId)
    {
        this.guildId = guildId;
        this.channelId = channelId;
    }

    public long getGuildId()
    {
        return guildId;
    }

    public long getChannelId()
    {
        return channelId;
    }
}