package discord.components;

import org.javacord.api.entity.message.MessageAuthor;

public class DAuthor
{
    private MessageAuthor author;

    public DAuthor(MessageAuthor author)
    {
        this.author = author;
    }

    public long getId()
    {
        return author.getId();
    }

    public String getAvatar()
    {
        return author.getAvatar().getUrl().toString();
    }

    public String getFullName()
    {
        return author.getDiscriminatedName();
    }
}