package discord;

import discord.components.functionality.command.MessageCommand;

import java.util.List;

/**
 * Discord instance
 */
public class Discord
{
    private DConnection connection;

    /**
     * Constructs with a token, prefix, and bot prefix
     *
     * @param token bot token
     * @param prefix prefix for standard users
     * @param botPrefix prefix for bots
     */
    public Discord(String token, String prefix, String botPrefix)
    {
        connection = new DConnection(token, prefix, botPrefix);
    }

    public void addCommands(List<MessageCommand> commands)
    {
        connection.addCommands(commands);
    }

    public void addSecretCommands(List<MessageCommand> secretCommands)
    {
        connection.addSecretCommands(secretCommands);
    }

    public void addBotCommands(List<MessageCommand> botCommands)
    {
        connection.addBotCommands(botCommands);
    }

    public void start()
    {
        connection.start();
    }

    public void stop()
    {
        connection.stop();
    }
}