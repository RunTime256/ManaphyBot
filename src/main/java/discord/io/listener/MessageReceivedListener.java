package discord.io.listener;

import discord.executor.MessageReceivedExecutor;
import discord.io.event.MessageReceivedEvent;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public class MessageReceivedListener implements MessageCreateListener
{
    private MessageReceivedExecutor executor;

    public MessageReceivedListener()
    {
        executor = new MessageReceivedExecutor();
    }

    @Override
    public void onMessageCreate(MessageCreateEvent messageCreateEvent)
    {
        MessageReceivedEvent event = new MessageReceivedEvent(messageCreateEvent);
        executor.execute(event);
    }
}
