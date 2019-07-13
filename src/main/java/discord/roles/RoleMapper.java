package discord.roles;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * Maps role functions from SQL
 */
public interface RoleMapper
{
    /**
     * Selects a role id
     *
     * @param guildId id of guild
     * @param name name of role
     * @return role id
     */
    @Select("SELECT role_id from bot.role WHERE guild_id = #{guildId} AND name = #{name}")
    @Results(value = {
            @Result(property = "role_id", column = "role_id")
    })
    Long getRole(@Param("guildId") long guildId, @Param("name") String name);
}