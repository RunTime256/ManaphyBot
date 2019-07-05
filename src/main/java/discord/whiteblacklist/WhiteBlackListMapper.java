package discord.whiteblacklist;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface WhiteBlackListMapper
{
    @Select("SELECT count(*) as count FROM bot.blacklist WHERE command = #{command}")
    @Results(value = {
            @Result(property = "count", column = "count")
    })
    Long getBlacklistSize(@Param("command") String command);

    @Select("SELECT dm FROM bot.blacklist WHERE command = #{command}")
    @Results(value = {
            @Result(property = "dm", column = "dm")
    })
    Boolean getDMBlacklist(@Param("command") String command);

    @Select("SELECT guild_id FROM bot.blacklist, bot.guild_blacklist " +
            "WHERE bot.blacklist.id = bot.guild_blacklist.blacklist_id " +
            "AND command = #{command} AND guild_id = #{guild_id}")
    @Results(value = {
            @Result(property = "guild_id", column = "guild_id")
    })
    List<Long> getGuildBlacklist(@Param("command") String command, @Param("guild_id") long guildId);

    @Select("SELECT category_id FROM bot.blacklist, bot.category_blacklist " +
            "WHERE bot.blacklist.id = bot.category_blacklist.blacklist_id " +
            "AND command = #{command} AND guild_id = #{guild_id} AND category_id = #{category_id}")
    @Results(value = {
            @Result(property = "category_id", column = "category_id")
    })
    List<Long> getCategoryBlacklist(@Param("command") String command, @Param("guild_id") long guildId, @Param("category_id") long categoryId);

    @Select("SELECT channel_id FROM bot.blacklist, bot.channel_blacklist " +
            "WHERE bot.blacklist.id = bot.channel_blacklist.blacklist_id " +
            "AND command = #{command} AND guild_id = #{guild_id} AND channel_id = #{channel_id}")
    @Results(value = {
            @Result(property = "channel_id", column = "channel_id")
    })
    List<Long> getChannelBlacklist(@Param("command") String command, @Param("guild_id") long guildId, @Param("channel_id") long channelId);

    @Select("SELECT count(*) as count FROM bot.whitelist WHERE command = #{command}")
    @Results(value = {
            @Result(property = "count", column = "count")
    })
    Long getWhitelistSize(@Param("command") String command);

    @Select("SELECT dm FROM bot.whitelist WHERE command = #{command}")
    @Results(value = {
            @Result(property = "dm", column = "dm")
    })
    Boolean getDMWhitelist(@Param("command") String command);

    @Select("SELECT count(*) as count FROM bot.whitelist, bot.guild_whitelist " +
            "WHERE bot.whitelist.id = bot.guild_whitelist.whitelist_id " +
            "AND command = #{command}")
    @Results(value = {
            @Result(property = "count", column = "count")
    })
    Long getGuildWhitelistSize(@Param("command") String command);

    @Select("SELECT guild_id FROM bot.whitelist, bot.guild_whitelist " +
            "WHERE bot.whitelist.id = bot.guild_whitelist.whitelist_id " +
            "AND command = #{command}")
    @Results(value = {
            @Result(property = "guild_id", column = "guild_id")
    })
    List<Long> getGuildWhitelist(@Param("command") String command, @Param("guild_id") long guildId);

    @Select("SELECT count(*) as count FROM bot.whitelist, bot.category_whitelist " +
            "WHERE bot.whitelist.id = bot.category_whitelist.whitelist_id " +
            "AND command = #{command} AND guild_id = #{guild_id}")
    @Results(value = {
            @Result(property = "count", column = "count")
    })
    Long getCategoryWhitelistSize(@Param("command") String command, @Param("guild_id") long guildId);

    @Select("SELECT category_id FROM bot.whitelist, bot.category_whitelist " +
            "WHERE bot.whitelist.id = bot.category_whitelist.whitelist_id " +
            "AND command = #{command} AND guild_id = #{guild_id} AND category_id = #{category_id}")
    @Results(value = {
            @Result(property = "category_id", column = "category_id")
    })
    List<Long> getCategoryWhitelist(@Param("command") String command, @Param("guild_id") long guildId, @Param("category_id") long categoryId);

    @Select("SELECT count(*) as count FROM bot.whitelist, bot.channel_whitelist " +
            "WHERE bot.whitelist.id = bot.channel_whitelist.whitelist_id " +
            "AND command = #{command} AND guild_id = #{guild_id}")
    @Results(value = {
            @Result(property = "count", column = "count")
    })
    Long getChannelWhitelistSize(@Param("command") String command, @Param("guild_id") long guildId);

    @Select("SELECT channel_id FROM bot.whitelist, bot.channel_whitelist " +
            "WHERE bot.whitelist.id = bot.channel_whitelist.whitelist_id " +
            "AND command = #{command} AND guild_id = #{guild_id} AND channel_id = #{channel_id}")
    @Results(value = {
            @Result(property = "channel_id", column = "channel_id")
    })
    List<Long> getChannelWhitelist(@Param("command") String command, @Param("guild_id") long guildId, @Param("channel_id") long channelId);
}