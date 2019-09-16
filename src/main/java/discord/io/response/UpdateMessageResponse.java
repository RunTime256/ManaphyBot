package discord.io.response;

import discord.builder.DEmbedBuilder;
import discord.components.DMessage;

public class UpdateMessageResponse
{
    private DMessage message;

    /**
     * Constructs with a message
     *
     * @param message message to update
     */
    public UpdateMessageResponse(DMessage message)
    {
        this.message = message;
    }

    public void updateMessage(String message)
    {
        this.message.updateMessage(message);
    }

    public void updateMessage(int x)
    {
        this.message.updateMessage(x);
    }

    public void updateMessage(DEmbedBuilder builder)
    {
        this.message.updateMessage(builder);
    }
}