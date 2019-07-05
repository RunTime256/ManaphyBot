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

public class MessageReceivedEvent
{
    private MessageCreateEvent event;
    private DAuthor author;
    private DChannel channel;
    private DMessage message;

    public MessageReceivedEvent(MessageCreateEvent event)
    {
        this.event = event;
        message = new DMessage(event.getMessage());
        channel = new DChannel(event.getChannel());
        author = new DAuthor(event.getMessageAuthor());
    }

    public DAuthor getAuthor()
    {
        return author;
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
        return channel;
    }

    public DMessage getMessage()
    {
        return message;
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