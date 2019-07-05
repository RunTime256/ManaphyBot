package discord.roles;

class RoleInstance
{
    private RoleMapper mapper;

    RoleInstance(RoleMapper mapper)
    {
        this.mapper = mapper;
    }

    Long getRole(long guildId, String name)
    {
        return mapper.getRole(guildId, name);
    }
}