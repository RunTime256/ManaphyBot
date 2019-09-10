package discord.io.listener;

import discord.components.functionality.Content;
import discord.components.functionality.command.ReactionCommand;
import discord.io.event.ReactionReceivedEvent;
import org.javacord.api.event.message.reaction.ReactionAddEvent;
import org.javacord.api.listener.message.reaction.ReactionAddListener;

public class ReactionReceivedListener implements ReactionAddListener
{
    private ReactionCommand command;
    private Content content;
    private long userId;
    private long messageId;

    public ReactionReceivedListener(ReactionCommand command, Content content, long userId, long messageId)
    {
        this.command = command;
        this.content = content;
        this.userId = userId;
        this.messageId = messageId;
    }

    @Override
    public void onReactionAdd(ReactionAddEvent reactionAddEvent)
    {
        ReactionReceivedEvent event = new ReactionReceivedEvent(reactionAddEvent);
        if (event.getMessageId() == messageId && event.getReactor().getId() == userId)
        {
            try
            {
                command.execute(event, content);
            }
            catch (Exception ignored)
            {
            }
        }
    }
}