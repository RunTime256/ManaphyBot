package discord.components;

import org.javacord.api.entity.message.Message;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    public Instant getTimestamp()
    {
        return message.getCreationTimestamp();
    }

    public void deleteMessage()
    {
        message.delete();
    }
}