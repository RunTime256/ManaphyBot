package discord.logging;

import discord.components.functionality.logging.LogInfo;
import sql.Session;
import sql.SessionFactory;

public class Log
{
    public Log()
    {

    }

    public LogInfo getLogInfo(String name)
    {
        try (Session session = SessionFactory.getSession())
        {
            LogInstance instance = new LogInstance(session.getMapper(LogMapper.class));
            return instance.getLogInfo(name);
        }
    }
}