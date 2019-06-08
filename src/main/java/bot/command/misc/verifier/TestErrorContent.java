package bot.command.misc.verifier;

import discord.io.response.MessageResponse;

public class TestErrorContent
{
    private int x;
    private int y;
    private MessageResponse sender;

    TestErrorContent(MessageResponse sender)
    {
        x = 1;
        y = 0;

        this.sender = sender;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public MessageResponse getSender()
    {
        return sender;
    }
}