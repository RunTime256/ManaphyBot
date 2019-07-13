package discord.whiteblacklist;

import sql.Session;
import sql.SessionFactory;

/**
 * Whitelist and Blacklist queries
 */
public class WhiteBlackList
{
    /**
     * Checks whitelist and blacklist to see if the command is allowed to be ran in DMs
     *
     * @param command command name
     * @return if the command is allowed to be used
     */
    public boolean isAllowedDM(String command)
    {
        try (Session session = SessionFactory.getSession())
        {
            WhiteBlackListInstance instance = new WhiteBlackListInstance(session.getMapper(WhiteBlackListMapper.class));
            return instance.isNotBlacklistedDM(command) && instance.isWhitelistAllowedDM(command);
        }
    }

    /**
     * Checks whitelist and blacklist to see if the command is allowed to be ran
     *
     * @param command command name
     * @param guildID guild id
     * @param channelID channel id
     * @return if the command is allowed to be used
     */
    public boolean isAllowed(String command, long guildID, long channelID)
    {
        try (Session session = SessionFactory.getSession())
        {
            WhiteBlackListInstance instance = new WhiteBlackListInstance(session.getMapper(WhiteBlackListMapper.class));
            return instance.isNotBlacklisted(command, guildID, channelID) && instance.isWhitelistAllowed(command, guildID, channelID);
        }
    }

    /**
     * Checks whitelist and blacklist to see if the command is allowed to be ran
     *
     * @param command command name
     * @param guildID guild id
     * @param categoryID category id
     * @param channelID channel id
     * @return if the command is allowed to be used
     */
    public boolean isAllowed(String command, long guildID, long categoryID, long channelID)
    {
        try (Session session = SessionFactory.getSession())
        {
            WhiteBlackListInstance instance = new WhiteBlackListInstance(session.getMapper(WhiteBlackListMapper.class));
            return instance.isNotBlacklisted(command, guildID, categoryID, channelID) && instance.isWhitelistAllowed(command, guildID, categoryID, channelID);
        }
    }
}