package discord;

import discord.io.listener.MessageReceivedListener;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

class DConnection
{
    private String token;
    private DiscordApi connection;

    DConnection(String token)
    {
        this.token = token;
    }

    void start()
    {
        connection = new DiscordApiBuilder().setToken(token).login().join();

        connection.addMessageCreateListener(new MessageReceivedListener());
    }

    void stop()
    {
        connection.disconnect();
    }
}