package discord.builder;

import org.javacord.api.entity.message.embed.EmbedBuilder;

import java.awt.*;

/**
 * Wrapper for Discord embed builders
 */
public class DEmbedBuilder
{
    private EmbedBuilder builder;

    public DEmbedBuilder()
    {
        builder = new EmbedBuilder();
    }

    public DEmbedBuilder setAuthor(String author)
    {
        builder.setAuthor(author);
        return this;
    }

    public DEmbedBuilder setIcon(String name, String url)
    {
        builder.setAuthor(name, "", url);
        return this;
    }

    public DEmbedBuilder setTitle(String title)
    {
        builder.setTitle(title);
        return this;
    }

    public DEmbedBuilder setDescription(String description)
    {
        builder.setDescription(description);
        return this;
    }

    public DEmbedBuilder setColor(Color color)
    {
        builder.setColor(color);
        return this;
    }

    public DEmbedBuilder setThumbnail(String url)
    {
        builder.setThumbnail(url);
        return this;
    }

    public DEmbedBuilder setFooter(String footer)
    {
        builder.setFooter(footer);
        return this;
    }

    public DEmbedBuilder addField(String name, String value)
    {
        builder.addField(name, value);
        return this;
    }

    public DEmbedBuilder addField(String name, int value)
    {
        builder.addField(name, String.valueOf(value));
        return this;
    }

    public DEmbedBuilder addField(String name, long value)
    {
        builder.addField(name, String.valueOf(value));
        return this;
    }

    public EmbedBuilder getBuilder()
    {
        return builder;
    }
}