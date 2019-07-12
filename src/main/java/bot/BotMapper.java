package bot;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * Map bot functions from SQL
 */
public interface BotMapper
{
    /**
     * Selects bot information to construct bot
     *
     * @param name name of the bot
     * @return Discord bot
     */
    @Select("SELECT name, token, prefix FROM bot.tokens WHERE name = #{name}")
    @Results(value = {
            @Result(property = "name", column = "name"),
            @Result(property = "token", column = "token"),
            @Result(property = "prefix", column = "prefix")
    })
    Bot getBot(String name);
}