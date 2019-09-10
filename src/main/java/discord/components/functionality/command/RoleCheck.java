package discord.components.functionality.command;

import discord.components.DApi;
import discord.components.DGuild;
import discord.guilds.Guild;
import discord.roles.Role;

public class RoleCheck
{
    public static boolean checkRole(DApi api, long userId, RoleRequirement requirement)
    {
        if (requirement == RoleRequirement.MANAGER)
        {
            return api.getOwner().getId() == userId;
        }

        long guildId = new Guild().getGuild("pokemon");
        long roleId = new Role().getRole(guildId, requirement.getRole());
        DGuild guild = api.getGuildById(guildId);
        return guild.getUserById(userId).hasRole(guild.getRoleById(roleId));
    }
}