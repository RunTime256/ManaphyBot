package discord.io.response;

import discord.builder.DEmbedBuilder;
import discord.components.DChannel;
import exception.ManaphyException;

import java.awt.*;

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
        exception.printStackTrace();
        String title = "An error occurred: " + exception.getClass().getSimpleName();
        String message;
        Color color;

        if (ManaphyException.class.isAssignableFrom(exception.getClass()))
        {
            message = exception.getMessage();
            color = ((ManaphyException)exception).getColor();
        }
        else
        {
            message = "This error has been logged and will be investigated.\n\n" +
                    "Please refrain from using this command until further notice.\n" +
                    "Thank you!";
            color = Color.RED;
        }

        DEmbedBuilder builder = new DEmbedBuilder();

        builder.setTitle(title).setDescription(message).setColor(color);

        return builder;
    }
}