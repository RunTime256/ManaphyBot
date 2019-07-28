package discord.guilds;

/**
 * Instance for guilds
 */
class GuildInstance
{
    private GuildMapper mapper;

    GuildInstance(GuildMapper mapper)
    {
        this.mapper = mapper;
    }

    Long getGuild(String name)
    {
        return mapper.getGuild(name);
    }
}