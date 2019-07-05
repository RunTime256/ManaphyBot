package discord.channels;

import sql.Session;
import sql.SessionFactory;

public class Channel
{
    public Channel()
    {

    }

    public Long getChannelId(String guildName, String channelName)
    {
        try (Session session = SessionFactory.getSession())
        {
            ChannelInstance instance = new ChannelInstance(session.getMapper(ChannelMapper.class));
            return instance.getChannelId(guildName, channelName);
        }
    }
}