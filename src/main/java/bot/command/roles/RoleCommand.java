package bot.command.roles;

import bot.command.roles.verifier.RoleAddContent;
import bot.command.roles.verifier.RoleAddVerifier;
import discord.channels.Channel;
import discord.components.DMessage;
import discord.components.functionality.command.MessageCommand;
import discord.components.functionality.verification.VerifiedMessage;
import exception.discord.roles.UserAlreadyHasRoleException;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RoleCommand
{
    private MessageCommand command;

    public RoleCommand()
    {
        command = createRoleAddCommand();
    }

    public MessageCommand getCommand()
    {
        return command;
    }

    private MessageCommand createRoleAddCommand()
    {
        Long channelId = new Channel().getChannelId("tgh", "rules");
        String channel = "#rules";
        if (channelId != null)
            channel = "<#" + channelId + ">";

        return new MessageCommand("join", "Join the family! Check " + channel + " for more details!", (this::roleAdd), new RoleAddVerifier());
    }

    private void roleAdd(VerifiedMessage<RoleAddContent> message)
    {
        RoleAddContent content = message.getContent();
        DMessage response = null;
        try
        {
            content.addRole();
            response = content.getSender().sendMessage("Welcome to the family, " + content.getUser().getMention() + "!");
        }
        catch (UserAlreadyHasRoleException e)
        {
            response = content.getSender().sendMessage("You already joined the family!");
        }
        finally
        {
            content.getMessage().deleteMessage();
            DMessage finalResponse = response;
            Executors.newSingleThreadScheduledExecutor().schedule(() -> {
                if (finalResponse != null)
                    finalResponse.deleteMessage();
            }, 10, TimeUnit.SECONDS);
        }
    }
}