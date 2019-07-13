package discord.builder;

import org.javacord.api.entity.message.MessageBuilder;

/**
 * Wrapper for Discord message builders
 */
public class DMessageBuilder
{
    private MessageBuilder builder;

    public DMessageBuilder()
    {
        builder = new MessageBuilder();
    }

    public DMessageBuilder append(String message)
    {
        builder.append(message);
        return this;
    }
}