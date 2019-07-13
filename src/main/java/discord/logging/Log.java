package discord.logging;

import discord.components.functionality.logging.LogInfo;
import sql.Session;
import sql.SessionFactory;

/**
 * Log queries
 */
public class Log
{
    public LogInfo getLogInfo(String name)
    {
        try (Session session = SessionFactory.getSession())
        {
            LogInstance instance = new LogInstance(session.getMapper(LogMapper.class));
            return instance.getLogInfo(name);
        }
    }
}