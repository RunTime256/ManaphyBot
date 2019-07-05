package bot.command.roles.verifier;

import discord.components.DMessage;
import discord.components.DUser;
import discord.io.response.MessageResponse;
import discord.io.response.RoleResponse;
import exception.discord.roles.UserAlreadyHasRoleException;
import exception.discord.roles.UserDoesNotHaveRoleException;
import org.apache.ibatis.annotations.Param;

public class RoleAddContent
{
    private DMessage message;
    private DUser user;
    private MessageResponse sender;
    private RoleResponse roleAdder;

    RoleAddContent(DMessage message, DUser user, MessageResponse sender, RoleResponse roleAdder)
    {
        this.message = message;
        this.user = user;
        this.sender = sender;
        this.roleAdder = roleAdder;
    }

    public DMessage getMessage()
    {
        return message;
    }

    public DUser getUser()
    {
        return user;
    }

    public MessageResponse getSender()
    {
        return sender;
    }

    public void addRole() throws UserAlreadyHasRoleException
    {
        roleAdder.addRole();
    }

    public void removeRole() throws UserDoesNotHaveRoleException
    {
        roleAdder.removeRole();
    }
}