package discord.io.event;

import discord.components.DApi;
import discord.components.DChannel;
import discord.components.DGuild;
import discord.components.DMessage;
import discord.components.DAuthor;
import discord.components.DUser;
import org.javacord.api.entity.server.Server;
import org.javacord.api.entity.user.User;
import org.javacord.api.event.message.MessageCreateEvent;

import java.util.Optional;

/**
 * Wrapper for Message Creation Events
 */
public class MessageReceivedEvent
{
    private MessageCreateEvent event;

    public MessageReceivedEvent(MessageCreateEvent event)
    {
        this.event = event;
    }

    public DAuthor getAuthor()
    {
        return new DAuthor(event.getMessageAuthor());
    }

    public DUser getUser()
    {
        Optional<User> user = event.getMessageAuthor().asUser();
        if (user.isPresent())
            return new DUser(user.get());
        else
            return null;
    }

    public DChannel getChannel()
    {
        return new DChannel(event.getChannel());
    }

    public DMessage getMessage()
    {
        return new DMessage(event.getMessage());
    }

    public DGuild getGuild()
    {
        Optional<Server> guild = event.getServer();
        if (guild.isPresent())
        {
            return new DGuild(guild.get());
        }
        return null;
    }

    public DApi getApi()
    {
        return new DApi(event.getApi());
    }

    public boolean isDM()
    {
        return event.isPrivateMessage();
    }

    public boolean isServerMessage()
    {
        return event.isServerMessage();
    }
}