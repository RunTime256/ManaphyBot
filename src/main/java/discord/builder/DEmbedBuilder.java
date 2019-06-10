package discord.builder;

import org.javacord.api.entity.message.embed.EmbedBuilder;

import java.awt.*;

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

    public EmbedBuilder getBuilder()
    {
        return builder;
    }
}