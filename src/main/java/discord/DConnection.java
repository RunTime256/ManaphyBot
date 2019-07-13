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
        messageReceivedListener = new MessageReceivedListener(prefix, botPrefix);
    }

    void addCommands(List<MessageCommand> commands)
    {
        messageReceivedListener.addCommands(commands);
    }

    void start()
    {
        connection = new DiscordApiBuilder().setToken(token).login().join();

        connection.addMessageCreateListener(messageReceivedListener);

        connection.updateActivity(ActivityType.WATCHING, "twitch.tv/tgh_sr");
    }

    void stop()
    {
        connection.disconnect();
    }
}