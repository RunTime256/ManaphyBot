package discord.components;

import org.javacord.api.entity.channel.ChannelCategory;

public class DCategory
{
    private ChannelCategory category;

    public DCategory(ChannelCategory category)
    {
        this.category = category;
    }

    public long getId()
    {
        return category.getId();
    }

    public String getName()
    {
        return category.getName();
    }
}