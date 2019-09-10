package discord.guilds;

import sql.Session;
import sql.SessionFactory;

/**
 * Guild queries
 */
public class Guild
{
    public Long getGuild(String name)
    {
        try (Session session = SessionFactory.getSession())
        {
            GuildInstance instance = new GuildInstance(session.getMapper(GuildMapper.class));
            return instance.getGuild(name);
        }
    }
}