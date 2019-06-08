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
    private MessageReceivedExecutor botCommandExecutor;

    public MessageReceivedListener(String prefix, String botPrefix)
    {
        executor = new MessageReceivedExecutor(prefix);
        botCommandExecutor = new MessageReceivedExecutor(botPrefix);
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
        if (!messageCreateEvent.getMessageAuthor().isBotUser())
        {
            executor.execute(event);
        }
        else if (!messageCreateEvent.getMessageAuthor().isYourself())
        {
            botCommandExecutor.execute(event);
        }
    }
}
