package discord.whiteblacklist;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface WhiteBlackListMapper
{
    @Select("SELECT dm FROM bot.blacklist WHERE command = #{command}")
    @Results(value = {
            @Result(property = "dm", column = "dm")
    })
    boolean getDMBlacklist(String command);

    @Select("SELECT guild_id FROM bot.blacklist, bot.guild_blacklist " +
            "WHERE bot.blacklist.id = bot.guild_blacklist.blacklist_id " +
            "AND command = #{command} AND guild_id = {#guild_id}")
    @Results(value = {
            @Result(property = "guild_id", column = "guild_id")
    })
    List<Long> getGuildBlacklist(String command, long guild_id);

    @Select("SELECT category_id FROM bot.blacklist, bot.category_blacklist " +
            "WHERE bot.blacklist.id = bot.category_blacklist.blacklist_id " +
            "AND command = #{command} AND guild_id = {#guild_id} AND category_id = #{category_id}")
    @Results(value = {
            @Result(property = "category_id", column = "category_id")
    })
    List<Long> getCategoryBlacklist(String command, long guild_id, long category_id);

    @Select("SELECT channel_id FROM bot.blacklist, bot.channel_blacklist " +
            "WHERE bot.blacklist.id = bot.channel_blacklist.blacklist_id " +
            "AND command = #{command} AND guild_id = {#guild_id} AND channel_id = #{channel_id}")
    @Results(value = {
            @Result(property = "channel_id", column = "channel_id")
    })
    List<Long> getChannelBlacklist(String command, long guild_id, long channel_id);

    @Select("SELECT dm FROM bot.whitelist WHERE command = #{command}")
    @Results(value = {
            @Result(property = "dm", column = "dm")
    })
    boolean getDMWhitelist(String command);

    @Select("SELECT count(*) as count FROM bot.whitelist, bot.guild_whitelist " +
            "WHERE bot.whitelist.id = bot.guild_whitelist.whitelist_id " +
            "AND command = #{command}")
    @Results(value = {
            @Result(property = "count", column = "count")
    })
    long getGuildWhitelistSize(String command);

    @Select("SELECT guild_id FROM bot.whitelist, bot.guild_whitelist " +
            "WHERE bot.whitelist.id = bot.guild_whitelist.whitelist_id " +
            "AND command = #{command}")
    @Results(value = {
            @Result(property = "guild_id", column = "guild_id")
    })
    List<Long> getGuildWhitelist(String command, long guild_id);

    @Select("SELECT count(*) as count FROM bot.whitelist, bot.guild_whitelist " +
            "WHERE bot.whitelist.id = bot.guild_whitelist.whitelist_id " +
            "AND command = #{command} AND guild_id = {#guild_id}")
    @Results(value = {
            @Result(property = "count", column = "count")
    })
    long getCategoryWhitelistSize(String command, long guild_id);

    @Select("SELECT category_id FROM bot.whitelist, bot.category_whitelist " +
            "WHERE bot.whitelist.id = bot.category_whitelist.whitelist_id " +
            "AND command = #{command} AND guild_id = {#guild_id} AND category_id = #{category_id}")
    @Results(value = {
            @Result(property = "category_id", column = "category_id")
    })
    List<Long> getCategoryWhitelist(String command, long guild_id, long category_id);

    @Select("SELECT count(*) as count FROM bot.whitelist, bot.channel_whitelist " +
            "WHERE bot.whitelist.id = bot.channel_whitelist.whitelist_id " +
            "AND command = #{command} AND guild_id = {#guild_id}")
    @Results(value = {
            @Result(property = "count", column = "count")
    })
    long getChannelWhitelistSize(String command, long guild_id);

    @Select("SELECT channel_id FROM bot.whitelist, bot.channel_whitelist " +
            "WHERE bot.whitelist.id = bot.channel_whitelist.whitelist_id " +
            "AND command = #{command} AND guild_id = {#guild_id} AND channel_id = #{channel_id}")
    @Results(value = {
            @Result(property = "channel_id", column = "channel_id")
    })
    List<Long> getChannelWhitelist(String command, long guild_id, long channel_id);
}