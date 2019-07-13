package discord.logging;

import discord.components.functionality.logging.LogInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * Maps log functions from SQL
 */
public interface LogMapper
{
    /**
     * Selects log information
     *
     * @param name name of log
     * @return log information with guild and channel ids
     */
    @Select("SELECT guild_id, channel_id FROM bot.log WHERE name = #{name}")
    @Results(value = {
            @Result(property = "guildId", column = "guild_id"),
            @Result(property = "channelId", column = "channel_id")
    })
    LogInfo getLogInfo(@Param("name") String name);
}