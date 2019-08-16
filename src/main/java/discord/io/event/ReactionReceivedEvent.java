package discord.io.event;

import discord.components.DEmoji;
import discord.components.DUser;
import org.javacord.api.event.message.reaction.ReactionAddEvent;

public class ReactionReceivedEvent
{
    private ReactionAddEvent event;

    public ReactionReceivedEvent(ReactionAddEvent event)
    {
        this.event = event;
    }

    public DEmoji getEmoji()
    {
        return new DEmoji(event.getEmoji());
    }

    public DUser getReactor()
    {
        return new DUser(event.getUser());
    }

    public long getMessageId()
    {
        return event.getMessageId();
    }
}