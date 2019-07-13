package bot.command.roles.verifier;

import discord.components.DMessage;
import discord.components.DUser;
import discord.components.functionality.verification.VerifiedMessage;
import discord.io.response.MessageResponse;
import discord.io.response.RoleResponse;

/**
 * Creates a verified role add command
 */
public class VerifiedRoleAdd implements VerifiedMessage<RoleAddContent>
{
    private RoleAddContent content;

    VerifiedRoleAdd(DMessage message, DUser user, MessageResponse sender, RoleResponse roleAdder)
    {
        content = new RoleAddContent(message, user, sender, roleAdder);
    }

    @Override
    public RoleAddContent getContent()
    {
        return content;
    }
}