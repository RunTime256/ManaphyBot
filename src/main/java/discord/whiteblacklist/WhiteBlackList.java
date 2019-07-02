package discord.whiteblacklist;

import sql.Session;
import sql.SessionFactory;

public class WhiteBlackList
{
    public boolean isAllowedDM(String command)
    {
        try (Session session = SessionFactory.getSession())
        {
            WhiteBlackListInstance instance = new WhiteBlackListInstance(session.getMapper(WhiteBlackListMapper.class));
            return instance.isNotBlacklistedDM(command) && instance.isWhitelistAllowedDM(command);
        }
    }

    public boolean isAllowed(String command, long guildID, long channelID)
    {
        try (Session session = SessionFactory.getSession())
        {
            WhiteBlackListInstance instance = new WhiteBlackListInstance(session.getMapper(WhiteBlackListMapper.class));
            return instance.isNotBlacklisted(command, guildID, channelID) && instance.isWhitelistAllowed(command, guildID, channelID);
        }
    }

    public boolean isAllowed(String command, long guildID, long categoryID, long channelID)
    {
        try (Session session = SessionFactory.getSession())
        {
            WhiteBlackListInstance instance = new WhiteBlackListInstance(session.getMapper(WhiteBlackListMapper.class));
            return instance.isNotBlacklisted(command, guildID, categoryID, channelID) && instance.isWhitelistAllowed(command, guildID, categoryID, channelID);
        }
    }
}