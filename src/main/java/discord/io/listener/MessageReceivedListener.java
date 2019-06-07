package discord.io.listener;

import discord.components.functionality.command.MessageCommand;
import discord.executor.MessageReceivedExecutor;
import discord.io.event.MessageReceivedEvent;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import java.util.List;

public class MessageReceivedListener implements MessageCreateListener
{
    private MessageReceivedExecutor executor;

    public MessageReceivedListener(String prefix)
    {
        executor = new MessageReceivedExecutor(prefix);
    }

    public void addCommands(List<MessageCommand> commands)
    {
        for (MessageCommand command: commands)
            executor.addCommand(command);
    }

    @Override
    public void onMessageCreate(MessageCreateEvent messageCreateEvent)
    {
        MessageReceivedEvent event = new MessageReceivedEvent(messageCreateEvent);
        executor.execute(event);
    }
}
