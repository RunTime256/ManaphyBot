package bot;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface BotMapper
{
    @Select("SELECT name, token FROM bot.tokens WHERE name = #{name}")
    @Results(value = {
            @Result(property = "name", column = "name"),
            @Result(property = "token", column = "token")
    })
    Bot getBot(String name);
}