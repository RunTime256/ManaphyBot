package bot.command.misc.verifier;

import discord.components.functionality.verification.VerifiedMessage;

public class TestVError implements VerifiedMessage<TestErrorContent>
{
    private TestErrorContent content;

    TestVError()
    {
        content = new TestErrorContent();
    }

    @Override
    public TestErrorContent getContent()
    {
        return content;
    }
}