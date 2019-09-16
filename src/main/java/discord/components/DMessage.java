package discord.components;

import discord.builder.DEmbedBuilder;
import discord.builder.DMessageBuilder;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.Reaction;
import org.javacord.api.entity.user.User;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Wrapper for Discord messages
 */
public class DMessage
{
    private Message message;

    public DMessage(Message message)
    {
        this.message = message;
    }

    public List<String> getSplitContent()
    {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, message.getContent().split(" "));

        return list;
    }

    public long getId()
    {
        return message.getId();
    }

    public Instant getTimestamp()
    {
        return message.getCreationTimestamp();
    }

    public void deleteMessage()
    {
        message.delete();
    }

    public void addReaction(String emoji)
    {
        message.addReaction(emoji);
    }

    public List<DReaction> getReactions()
    {
        List<DReaction> reactions = new ArrayList<>();
        for (Reaction reaction: message.getReactions())
        {
            reactions.add(new DReaction(reaction));
        }
        return reactions;
    }

    public DUser getAuthor()
    {
        Optional<User> author = message.getUserAuthor();
        if (author.isPresent())
            return new DUser(author.get());
        else
            return null;
    }

    public void updateMessage(String message)
    {
        this.message.edit(message);
    }

    public void updateMessage(int x)
    {
        this.message.edit(String.valueOf(x));
    }

    public void updateMessage(DEmbedBuilder builder)
    {
        this.message.edit(builder.getBuilder());
    }
}