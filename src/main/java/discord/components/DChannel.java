package discord.components;

import discord.builder.DEmbedBuilder;
import discord.builder.DMessageBuilder;
import discord.components.functionality.Content;
import discord.components.functionality.command.ReactionCommand;
import discord.io.listener.ReactionReceivedListener;
import org.javacord.api.entity.channel.ChannelCategory;
import org.javacord.api.entity.channel.ServerTextChannel;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.listener.message.reaction.ReactionAddListener;

import java.util.Optional;

/**
 * Wrapper for Discord channels
 */
public class DChannel
{
    private TextChannel channel;

    public DChannel(TextChannel channel)
    {
        this.channel = channel;
    }

    public long getId()
    {
        return channel.getId();
    }

    public DCategory getCategory()
    {
        Optional<ServerTextChannel> serverChannel = channel.asServerTextChannel();
        if (serverChannel.isPresent())
        {
            Optional<ChannelCategory> category = serverChannel.get().getCategory();
            if (category.isPresent())
                return new DCategory(category.get());
        }

        return null;
    }

    public DMessage sendMessage(String message)
    {
        return new DMessage(channel.sendMessage(message).join());
    }

    public DMessage sendMessage(DEmbedBuilder builder)
    {
        return new DMessage(channel.sendMessage(builder.getBuilder()).join());
    }

    public DMessage sendMessage(DMessageBuilder builder)
    {
        return new DMessage(builder.getBuilder().send(channel).join());
    }

    public void addReactionListener(ReactionCommand command, Content content, long userId, long messageId)
    {
        ReactionReceivedListener reactionAddListener = new ReactionReceivedListener(command, content, userId, messageId);
        channel.addReactionAddListener(reactionAddListener);
        command.addListener(this, reactionAddListener);
    }

    public void removeReactionListener(ReactionReceivedListener listener)
    {
        channel.removeListener(ReactionAddListener.class, listener);
    }
}
