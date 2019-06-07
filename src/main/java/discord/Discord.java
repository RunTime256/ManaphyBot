package discord;

import discord.io.listener.MessageReceivedListener;

public class Discord
{
    private DConnection connection;

    public Discord(String token, String prefix)
    {
        connection = new DConnection(token);
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