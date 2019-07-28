package discord;

import discord.components.functionality.command.MessageCommand;
import discord.io.listener.MessageReceivedListener;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.activity.ActivityType;

import java.util.List;

/**
 * Connection to Discord
 */
class DConnection
{
    private String token;
    private String prefix;
    private DiscordApi connection;
    private MessageReceivedListener messageReceivedListener;

    /**
     * Constructs a connection to Discord
     *
     * @param token bot token
     * @param prefix prefix for standard users
     * @param botPrefix prefix for bots
     */
    DConnection(String token, String prefix, String botPrefix)
    {
        this.token = token;
        this.prefix = prefix;
        messageReceivedListener = new MessageReceivedListener(prefix, botPrefix);
    }

    void addCommands(List<MessageCommand> commands)
    {
        messageReceivedListener.addCommands(commands);
    }

    void addSecretCommands(List<MessageCommand> secretCommands)
    {
        messageReceivedListener.addSecretCommands(secretCommands);
    }

    void addBotCommands(List<MessageCommand> botCommands)
    {
        messageReceivedListener.addBotCommands(botCommands);
    }

    void start()
    {
        connection = new DiscordApiBuilder().setToken(token).login().join();

        connection.addMessageCreateListener(messageReceivedListener);
    }

    void stop()
    {
        connection.disconnect();
    }
}