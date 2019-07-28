package discord.guilds;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * Maps guild functions from SQL
 */
public interface GuildMapper
{
    /**
     * Selects a guild id
     *
     * @param name name of guild
     * @return guild id
     */
    @Select("SELECT guild_id from bot.guild WHERE name = #{name}")
    @Results(value = {
            @Result(property = "guild_id", column = "guild_id")
    })
    Long getGuild(@Param("name") String name);
}