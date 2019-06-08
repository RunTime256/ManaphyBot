package bot.command.misc.verifier;

import discord.components.functionality.verification.VerifiedMessage;
import discord.io.response.MessageResponse;

public class TestVError implements VerifiedMessage<TestErrorContent>
{
    private TestErrorContent content;

    TestVError(MessageResponse response)
    {
        content = new TestErrorContent(response);
    }

    @Override
    public TestErrorContent getContent()
    {
        return content;
    }
}