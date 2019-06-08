package discord.io.response;

import discord.builder.DEmbedBuilder;
import discord.components.DChannel;

public class ErrorResponse
{
    private Exception exception;
    private DChannel channel;

    public ErrorResponse(Exception exception, DChannel channel)
    {
        this.exception = exception;
        this.channel = channel;
    }

    public void sendErrorMessage()
    {
        MessageResponse response = new MessageResponse(channel);

        response.sendMessage(createErrorEmbed());
    }

    private DEmbedBuilder createErrorEmbed()
    {
        DEmbedBuilder builder = new DEmbedBuilder();

        builder.setTitle(exception.getClass().getName());
        builder.setDescription(exception.toString());

        return builder;
    }
}