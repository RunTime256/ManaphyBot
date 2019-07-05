package discord.roles;

import sql.Session;
import sql.SessionFactory;

public class Role
{
    public Role()
    {

    }

    public Long getRole(long guildId, String name)
    {
        try (Session session = SessionFactory.getSession())
        {
            RoleInstance instance = new RoleInstance(session.getMapper(RoleMapper.class));
            return instance.getRole(guildId, name);
        }
    }
}