package discord.components;

import org.javacord.api.entity.message.Message;

import java.util.Arrays;
import java.util.List;

public class DMessage
{
    private Message message;

    public DMessage(Message message)
    {
        this.message = message;
    }

    public List<String> getSplitContent()
    {
        String content = message.getContent();
        return Arrays.asList(content.split(" "));
    }
}