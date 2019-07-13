package bot.command.roles.verifier;

import discord.components.DGuild;
import discord.components.DMessage;
import discord.components.DRole;
import discord.components.DUser;
import discord.components.functionality.verification.MessageVerifier;
import discord.components.functionality.verification.VerifiedMessage;
import discord.io.event.MessageReceivedEvent;
import discord.io.response.MessageResponse;
import discord.io.response.RoleResponse;
import discord.roles.Role;
import exception.bot.command.InvalidArgumentsException;

/**
 * Verifies a role add command
 */
public class RoleAddVerifier extends MessageVerifier<RoleAddContent>
{
    @Override
    public VerifiedMessage<RoleAddContent> verifyMessage(String message, MessageReceivedEvent event) throws InvalidArgumentsException
    {
        DRole role = verifyRole(verifyRoleName(message), event.getGuild());
        DUser user = verifyUser(event.getUser());
        DMessage dMessage = event.getMessage();
        return new VerifiedRoleAdd(dMessage, user, new MessageResponse(event.getChannel()), new RoleResponse(user, role));
    }

    /**
     * Verifies role name
     *
     * @param message message content
     * @return role name
     * @throws InvalidArgumentsException if role name was not provided
     */
    private String verifyRoleName(String message) throws InvalidArgumentsException
    {
        if (message.isEmpty())
            throw new InvalidArgumentsException("Please provide a role name.");

        return message.toLowerCase();
    }

    /**
     * Verifies role
     *
     * @param roleName name of role
     * @param guild guild to get role from
     * @return role
     * @throws InvalidArgumentsException if the role does not exist in the database or guild
     */
    private DRole verifyRole(String roleName, DGuild guild) throws InvalidArgumentsException
    {
        Role role = new Role();
        Long roleId = role.getRole(guild.getId(), roleName);
        if (roleId == null)
            throw new InvalidArgumentsException("Please provide a valid role name.");
        DRole dRole = guild.getRoleById(roleId);
        if (dRole == null)
            throw new InvalidArgumentsException("Please provide a valid role name.");

        return dRole;
    }

    /**
     * Verifies the user is in the guild to add the role
     *
     * @param user user to add role to
     * @return user
     * @throws InvalidArgumentsException if the user is not in the guild
     */
    private DUser verifyUser(DUser user) throws InvalidArgumentsException
    {
        if (user == null)
            throw new InvalidArgumentsException("You must be in a server!");

        return user;
    }
}