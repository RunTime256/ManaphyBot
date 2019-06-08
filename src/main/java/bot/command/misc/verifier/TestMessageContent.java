package bot.command.misc.verifier;

import discord.io.response.MessageResponse;

public class TestMessageContent
{
    private String message;
    private MessageResponse sender;

    TestMessageContent(String message, MessageResponse sender)
    {
        this.message = message;
        this.sender = sender;
    }

    public String getMessage()
    {
        return message;
    }

    public MessageResponse getSender()
    {
        return sender;
    }
}