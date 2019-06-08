package discord;

import discord.components.functionality.command.MessageCommand;

import java.util.List;

public class Discord
{
    private DConnection connection;

    public Discord(String token, String prefix, String botPrefix)
    {
        connection = new DConnection(token, prefix, botPrefix);
    }

    public void addCommands(List<MessageCommand> commands)
    {
        connection.addCommands(commands);
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