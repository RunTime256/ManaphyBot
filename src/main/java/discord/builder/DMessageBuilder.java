package discord.builder;

import org.javacord.api.entity.message.MessageBuilder;

import java.net.MalformedURLException;
import java.net.URL;

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

    public DMessageBuilder appendImage(String url)
    {
        try
        {
            builder.addAttachment(new URL(url));
        }
        catch (MalformedURLException ignored)
        {
        }
        return this;
    }

    public MessageBuilder getBuilder()
    {
        return builder;
    }
}