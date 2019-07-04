package discord.logging;

import discord.components.functionality.logging.LogInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

interface LogMapper
{
    @Select("SELECT guild_id, channel_id FROM bot.log WHERE name = #{name}")
    @Results(value = {
            @Result(property = "guild_id", column = "guild_id"),
            @Result(property = "channel_id", column = "channel_id")
    })
    LogInfo getLogInfo(@Param("name") String name);
}