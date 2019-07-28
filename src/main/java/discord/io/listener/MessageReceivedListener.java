package discord.io.listener;

import discord.components.functionality.command.MessageCommand;
import discord.executor.MessageReceivedExecutor;
import discord.io.event.MessageReceivedEvent;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import java.util.List;

/**
 * Listens for new messages
 */
public class MessageReceivedListener implements MessageCreateListener
{
    private MessageReceivedExecutor executor;
    private MessageReceivedExecutor secretExecutor;
    private MessageReceivedExecutor botExecutor;

    /**
     * Constructs a listener with command prefixes
     *
     * @param prefix prefix for standard users
     * @param botPrefix prefix for bots
     */
    public MessageReceivedListener(String prefix, String botPrefix)
    {
        executor = new MessageReceivedExecutor(prefix);
        secretExecutor = new MessageReceivedExecutor(prefix);
        botExecutor = new MessageReceivedExecutor(botPrefix);
    }

    public void addCommands(List<MessageCommand> commands)
    {
        for (MessageCommand command: commands)
            executor.addCommand(command);
    }

    public void addSecretCommands(List<MessageCommand> secretCommands)
    {
        for (MessageCommand command: secretCommands)
            secretExecutor.addCommand(command);
    }

    public void addBotCommands(List<MessageCommand> botCommands)
    {
        for (MessageCommand command: botCommands)
            botExecutor.addCommand(command);
    }

    /**
     * Executes a command upon message creation
     *
     * @param messageCreateEvent new message event
     */
    @Override
    public void onMessageCreate(MessageCreateEvent messageCreateEvent)
    {
        MessageReceivedEvent event = new MessageReceivedEvent(messageCreateEvent);
        if (!messageCreateEvent.getMessageAuthor().isBotUser())
        {
            if (!secretExecutor.secretExecute(event))
                executor.execute(event);
        }
        else if (!messageCreateEvent.getMessageAuthor().isYourself())
        {
            botExecutor.execute(event);
        }
    }
}