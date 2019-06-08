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

    public void setTitle(String title)
    {
        builder.setTitle(title);
    }

    public void setDescription(String description)
    {
        builder.setDescription(description);
    }

    public void setColor(Color color)
    {
        builder.setColor(color);
    }

    public EmbedBuilder getBuilder()
    {
        return builder;
    }
}