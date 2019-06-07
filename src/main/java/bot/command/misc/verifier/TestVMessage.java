package bot.command.misc.verifier;

import discord.components.functionality.verification.VerifiedMessage;
import discord.io.response.MessageResponse;

public class TestVMessage implements VerifiedMessage<TestContent>
{
    private TestContent content;

    TestVMessage(String message, MessageResponse response)
    {
        content = new TestContent(message, response);
    }

    @Override
    public TestContent getContent()
    {
        return content;
    }
}
