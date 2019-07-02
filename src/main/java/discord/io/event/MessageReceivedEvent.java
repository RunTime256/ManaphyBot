package discord.io.event;

import discord.components.DChannel;
import discord.components.DGuild;
import discord.components.DMessage;
import discord.components.DAuthor;
import org.javacord.api.entity.server.Server;
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

    public boolean isDM()
    {
        return event.isPrivateMessage();
    }

    public boolean isServerMessage()
    {
        return event.isServerMessage();
    }
}