package discord.whiteblacklist;

import sql.Session;
import sql.SessionWrapper;

public class WhiteBlackList
{
    private Session session;

    public WhiteBlackList(Session session)
    {
        this.session = session;
    }

    public boolean isAllowedDM(String command)
    {
        return isNotBlacklistedDM(command) && isWhitelistAllowedDM(command);
    }

    public boolean isAllowed(String command, long guildID, long channelID)
    {
        return isNotBlacklisted(command, guildID, channelID) && isWhitelistAllowed(command, guildID, channelID);
    }

    public boolean isAllowed(String command, long guildID, long categoryID, long channelID)
    {
        return isNotBlacklisted(command, guildID, categoryID, channelID) && isWhitelistAllowed(command, guildID, categoryID, channelID);
    }

    private boolean isNotBlacklistedDM(String command)
    {
        return false;
    }

    private boolean isNotBlacklisted(String command, long guildID, long channelID)
    {
        boolean ret = true;
        try (SessionWrapper wrapper = new SessionWrapper(session))
        {
            WhiteBlackListMapper mapper = wrapper.getMapper(WhiteBlackListMapper.class);
            if (!mapper.getGuildBlacklist(command, guildID).isEmpty() ||
                    !mapper.getChannelBlacklist(command, guildID, channelID).isEmpty())
                ret = false;
        }

        return ret;
    }

    private boolean isNotBlacklisted(String command, long guildID, long categoryID, long channelID)
    {
        boolean ret = true;
        try (SessionWrapper wrapper = new SessionWrapper(session))
        {
            WhiteBlackListMapper mapper = wrapper.getMapper(WhiteBlackListMapper.class);
            if (!mapper.getGuildBlacklist(command, guildID).isEmpty() ||
                    !mapper.getCategoryBlacklist(command, guildID, categoryID).isEmpty() ||
                    !mapper.getChannelBlacklist(command, guildID, channelID).isEmpty())
                ret = false;
        }

        return ret;
    }

    private boolean isWhitelistAllowedDM(String command)
    {
        return true;
    }

    private boolean isWhitelistAllowed(String command, long guildID, long channelID)
    {
        return true;
    }

    private boolean isWhitelistAllowed(String command, long guildID, long categoryID, long channelID)
    {
        return true;
    }
}