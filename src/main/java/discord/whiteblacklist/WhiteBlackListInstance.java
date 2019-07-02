package discord.whiteblacklist;

class WhiteBlackListInstance
{
    private WhiteBlackListMapper mapper;

    WhiteBlackListInstance(WhiteBlackListMapper mapper)
    {
        this.mapper = mapper;
    }

    boolean isNotBlacklistedDM(String command)
    {
        boolean ret = true;
        if (mapper.getDMBlacklist(command))
            ret = false;

        return ret;
    }

    boolean isNotBlacklisted(String command, long guildID, long channelID)
    {
        boolean ret = true;
        if (!mapper.getGuildBlacklist(command, guildID).isEmpty() ||
                !mapper.getChannelBlacklist(command, guildID, channelID).isEmpty())
            ret = false;

        return ret;
    }

    boolean isNotBlacklisted(String command, long guildID, long categoryID, long channelID)
    {
        boolean ret = true;
        if (!mapper.getGuildBlacklist(command, guildID).isEmpty() ||
                !mapper.getCategoryBlacklist(command, guildID, categoryID).isEmpty() ||
                !mapper.getChannelBlacklist(command, guildID, channelID).isEmpty())
            ret = false;

        return ret;
    }

    boolean isWhitelistAllowedDM(String command)
    {
        boolean ret = true;
        if (!mapper.getDMWhitelist(command))
            ret = false;

        return ret;
    }

    boolean isWhitelistAllowed(String command, long guildID, long channelID)
    {
        boolean ret = true;
        if (mapper.getGuildWhitelistSize(command) > 0 && mapper.getGuildWhitelist(command, guildID).isEmpty() ||
                mapper.getChannelWhitelistSize(command, guildID) > 0 && mapper.getChannelWhitelist(command, guildID, channelID).isEmpty())
            ret = false;

        return ret;
    }

    boolean isWhitelistAllowed(String command, long guildID, long categoryID, long channelID)
    {
        boolean ret = true;
        if (mapper.getGuildWhitelistSize(command) > 0 && mapper.getGuildWhitelist(command, guildID).isEmpty() ||
                mapper.getCategoryWhitelistSize(command, guildID) > 0 && mapper.getCategoryWhitelist(command, guildID, categoryID).isEmpty() ||
                mapper.getChannelWhitelistSize(command, guildID) > 0 && mapper.getChannelWhitelist(command, guildID, channelID).isEmpty())
            ret = false;

        return ret;
    }
}