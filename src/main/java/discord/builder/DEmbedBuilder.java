package discord.builder;

import org.javacord.api.entity.message.embed.EmbedBuilder;

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

    public EmbedBuilder getBuilder()
    {
        return builder;
    }
}