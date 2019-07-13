package discord.whiteblacklist;

/**
 * Instance for whitelists and blacklists
 */
class WhiteBlackListInstance
{
    private WhiteBlackListMapper mapper;

    WhiteBlackListInstance(WhiteBlackListMapper mapper)
    {
        this.mapper = mapper;
    }

    boolean isNotBlacklistedDM(String command)
    {
        if (hasNoBlacklist(command))
            return true;

        boolean ret = false;
        Boolean bool = mapper.getDMBlacklist(command);
        if (bool == null || bool)
            ret = true;

        return !ret;
    }

    boolean isNotBlacklisted(String command, long guildID, long channelID)
    {
        if (hasNoBlacklist(command))
            return true;

        boolean ret = false;
        if (!mapper.getGuildBlacklist(command, guildID).isEmpty() ||
                !mapper.getChannelBlacklist(command, guildID, channelID).isEmpty())
            ret = true;

        return !ret;
    }

    boolean isNotBlacklisted(String command, long guildID, long categoryID, long channelID)
    {
        if (hasNoBlacklist(command))
            return true;

        boolean ret = false;
        if (!mapper.getGuildBlacklist(command, guildID).isEmpty() ||
                !mapper.getCategoryBlacklist(command, guildID, categoryID).isEmpty() ||
                !mapper.getChannelBlacklist(command, guildID, channelID).isEmpty())
            ret = true;

        return !ret;
    }

    boolean isWhitelistAllowedDM(String command)
    {
        if (hasNoWhitelist(command))
            return true;

        boolean ret = true;
        Boolean bool = mapper.getDMWhitelist(command);
        if (bool == null || !bool)
            ret = false;

        return ret;
    }

    boolean isWhitelistAllowed(String command, long guildID, long channelID)
    {
        if (hasNoWhitelist(command))
            return true;

        boolean ret = true;
        if ((isWhitelistAllowedDM(command) &&
                mapper.getGuildWhitelistSize(command) == 0 && mapper.getChannelWhitelistSize(command, guildID) == 0) ||
                (mapper.getGuildWhitelistSize(command) > 0 && mapper.getGuildWhitelist(command, guildID).isEmpty() ||
                        mapper.getChannelWhitelistSize(command, guildID) > 0 && mapper.getChannelWhitelist(command, guildID, channelID).isEmpty()))
            ret = false;

        return ret;
    }

    boolean isWhitelistAllowed(String command, long guildID, long categoryID, long channelID)
    {
        if (hasNoWhitelist(command))
            return true;

        boolean ret = true;
        if ((isWhitelistAllowedDM(command) && mapper.getGuildWhitelistSize(command) == 0 &&
                mapper.getCategoryWhitelistSize(command, guildID) == 0 && mapper.getChannelWhitelistSize(command, guildID) == 0) ||
                (mapper.getGuildWhitelistSize(command) > 0 && mapper.getGuildWhitelist(command, guildID).isEmpty() ||
                mapper.getCategoryWhitelistSize(command, guildID) > 0 && mapper.getCategoryWhitelist(command, guildID, categoryID).isEmpty() ||
                mapper.getChannelWhitelistSize(command, guildID) > 0 && mapper.getChannelWhitelist(command, guildID, channelID).isEmpty()))
            ret = false;

        return ret;
    }

    private boolean hasNoBlacklist(String command)
    {
        boolean ret = false;
        if (mapper.getBlacklistSize(command) > 0)
            ret = true;

        return !ret;
    }

    private boolean hasNoWhitelist(String command)
    {
        boolean ret = false;
        if (mapper.getWhitelistSize(command) > 0)
            ret = true;

        return !ret;
    }
}