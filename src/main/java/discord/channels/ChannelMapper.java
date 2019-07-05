package discord.channels;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ChannelMapper
{
    @Select("SELECT channel_id FROM bot.channel LEFT JOIN bot.guild ON bot.guild.guild_id = bot.channel.guild_id " +
            "WHERE bot.guild.name = #{guildName} AND bot.channel.name = #{channelName}")
    Long getChannelId(@Param("guildName") String guildName, @Param("channelName") String channelName);
}