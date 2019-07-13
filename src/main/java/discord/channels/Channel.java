package discord.channels;

import sql.Session;
import sql.SessionFactory;

/**
 * Channel queries
 */
public class Channel
{
    public Long getChannelId(String guildName, String channelName)
    {
        try (Session session = SessionFactory.getSession())
        {
            ChannelInstance instance = new ChannelInstance(session.getMapper(ChannelMapper.class));
            return instance.getChannelId(guildName, channelName);
        }
    }
}