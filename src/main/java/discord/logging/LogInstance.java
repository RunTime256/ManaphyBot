package discord.logging;

import discord.components.functionality.logging.LogInfo;

/**
 * Instance for logs
 */
class LogInstance
{
    private LogMapper mapper;

    LogInstance(LogMapper mapper)
    {
        this.mapper = mapper;
    }

    LogInfo getLogInfo(String name)
    {
        return mapper.getLogInfo(name);
    }
}