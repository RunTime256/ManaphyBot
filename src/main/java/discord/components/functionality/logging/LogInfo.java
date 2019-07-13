package discord.components.functionality.logging;

/**
 * Information for logging channels
 */
public class LogInfo
{
    private long guildId;
    private long channelId;

    /**
     * Constructs log information with guild and channel
     *
     * @param guildId id of logging guild
     * @param channelId id of logging channel
     */
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