package discord.channels;

class ChannelInstance
{
    private ChannelMapper mapper;

    ChannelInstance(ChannelMapper mapper)
    {
        this.mapper = mapper;
    }

    Long getChannelId(String guildName, String channelName)
    {
        return mapper.getChannelId(guildName, channelName);
    }
}