package discord.whiteblacklist;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Maps whitelist and blacklist functions from SQL
 */
public interface WhiteBlackListMapper
{
    /**
     * Selects the count of commands that have a blacklist
     *
     * @param command command name
     * @return count of commands that have a blacklist
     */
    @Select("SELECT count(*) as count FROM bot.blacklist WHERE command = #{command}")
    @Results(value = {
            @Result(property = "count", column = "count")
    })
    Long getBlacklistSize(@Param("command") String command);

    /**
     * Selects if DMs are blacklisted for a command
     *
     * @param command command name
     * @return if DMs are blacklisted
     */
    @Select("SELECT dm FROM bot.blacklist WHERE command = #{command}")
    @Results(value = {
            @Result(property = "dm", column = "dm")
    })
    Boolean getDMBlacklist(@Param("command") String command);

    /**
     * Selects guilds under the command blacklist that match
     *
     * @param command command name
     * @param guildId guild id
     * @return list of guilds under the guild
     */
    @Select("SELECT guild_id FROM bot.blacklist, bot.guild_blacklist " +
            "WHERE bot.blacklist.id = bot.guild_blacklist.blacklist_id " +
            "AND command = #{command} AND guild_id = #{guild_id}")
    @Results(value = {
            @Result(property = "guild_id", column = "guild_id")
    })
    List<Long> getGuildBlacklist(@Param("command") String command, @Param("guild_id") long guildId);

    /**
     * Selects categories under the command blacklist that match
     *
     * @param command command name
     * @param guildId guild id
     * @param categoryId category id
     * @return list of categories under the blacklist
     */
    @Select("SELECT category_id FROM bot.blacklist, bot.category_blacklist " +
            "WHERE bot.blacklist.id = bot.category_blacklist.blacklist_id " +
            "AND command = #{command} AND guild_id = #{guild_id} AND category_id = #{category_id}")
    @Results(value = {
            @Result(property = "category_id", column = "category_id")
    })
    List<Long> getCategoryBlacklist(@Param("command") String command, @Param("guild_id") long guildId, @Param("category_id") long categoryId);

    /**
     * Selects channels under the command blacklist that match
     *
     * @param command command name
     * @param guildId guild id
     * @param channelId channel id
     * @return list of channels under the blacklist
     */
    @Select("SELECT channel_id FROM bot.blacklist, bot.channel_blacklist " +
            "WHERE bot.blacklist.id = bot.channel_blacklist.blacklist_id " +
            "AND command = #{command} AND guild_id = #{guild_id} AND channel_id = #{channel_id}")
    @Results(value = {
            @Result(property = "channel_id", column = "channel_id")
    })
    List<Long> getChannelBlacklist(@Param("command") String command, @Param("guild_id") long guildId, @Param("channel_id") long channelId);

    /**
     * Selects the count of commands that have a whitelist
     *
     * @param command command name
     * @return count of commands that have a whitelist
     */
    @Select("SELECT count(*) as count FROM bot.whitelist WHERE command = #{command}")
    @Results(value = {
            @Result(property = "count", column = "count")
    })
    Long getWhitelistSize(@Param("command") String command);

    /**
     * Selects if DMs are whitelisted for a command
     *
     * @param command command name
     * @return if DMs are whitelisted
     */
    @Select("SELECT dm FROM bot.whitelist WHERE command = #{command}")
    @Results(value = {
            @Result(property = "dm", column = "dm")
    })
    Boolean getDMWhitelist(@Param("command") String command);

    /**
     * Selects the count of guilds under a whitelist command
     *
     * @param command command name
     * @return count of guilds under a whitelist
     */
    @Select("SELECT count(*) as count FROM bot.whitelist, bot.guild_whitelist " +
            "WHERE bot.whitelist.id = bot.guild_whitelist.whitelist_id " +
            "AND command = #{command}")
    @Results(value = {
            @Result(property = "count", column = "count")
    })
    Long getGuildWhitelistSize(@Param("command") String command);

    /**
     * Selects guilds under the command whitelist that match
     *
     * @param command command name
     * @param guildId guild id
     * @return list of guilds under the whitelist
     */
    @Select("SELECT guild_id FROM bot.whitelist, bot.guild_whitelist " +
            "WHERE bot.whitelist.id = bot.guild_whitelist.whitelist_id " +
            "AND command = #{command}")
    @Results(value = {
            @Result(property = "guild_id", column = "guild_id")
    })
    List<Long> getGuildWhitelist(@Param("command") String command, @Param("guild_id") long guildId);

    /**
     * Selects the count of categories under a whitelist command
     *
     * @param command command name
     * @param guildId guild id
     * @return count of categories under a whitelist
     */
    @Select("SELECT count(*) as count FROM bot.whitelist, bot.category_whitelist " +
            "WHERE bot.whitelist.id = bot.category_whitelist.whitelist_id " +
            "AND command = #{command} AND guild_id = #{guild_id}")
    @Results(value = {
            @Result(property = "count", column = "count")
    })
    Long getCategoryWhitelistSize(@Param("command") String command, @Param("guild_id") long guildId);

    /**
     * Selects categories under the command whitelist that match
     *
     * @param command command name
     * @param guildId guild id
     * @param categoryId category id
     * @return list of categories under the whitelist
     */
    @Select("SELECT category_id FROM bot.whitelist, bot.category_whitelist " +
            "WHERE bot.whitelist.id = bot.category_whitelist.whitelist_id " +
            "AND command = #{command} AND guild_id = #{guild_id} AND category_id = #{category_id}")
    @Results(value = {
            @Result(property = "category_id", column = "category_id")
    })
    List<Long> getCategoryWhitelist(@Param("command") String command, @Param("guild_id") long guildId, @Param("category_id") long categoryId);

    /**
     * Selects the count of channels under a whitelist command
     *
     * @param command command name
     * @param guildId guild id
     * @return count of channels under the whitelist
     */
    @Select("SELECT count(*) as count FROM bot.whitelist, bot.channel_whitelist " +
            "WHERE bot.whitelist.id = bot.channel_whitelist.whitelist_id " +
            "AND command = #{command} AND guild_id = #{guild_id}")
    @Results(value = {
            @Result(property = "count", column = "count")
    })
    Long getChannelWhitelistSize(@Param("command") String command, @Param("guild_id") long guildId);

    /**
     * Selects channels under the command whitelist that match
     *
     * @param command command name
     * @param guildId guild id
     * @param channelId channel id
     * @return list of channels under the whitelist
     */
    @Select("SELECT channel_id FROM bot.whitelist, bot.channel_whitelist " +
            "WHERE bot.whitelist.id = bot.channel_whitelist.whitelist_id " +
            "AND command = #{command} AND guild_id = #{guild_id} AND channel_id = #{channel_id}")
    @Results(value = {
            @Result(property = "channel_id", column = "channel_id")
    })
    List<Long> getChannelWhitelist(@Param("command") String command, @Param("guild_id") long guildId, @Param("channel_id") long channelId);
}