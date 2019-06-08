package bot.command.misc.verifier;

import discord.components.functionality.verification.VerifiedMessage;

public class VerifiedTestError implements VerifiedMessage<TestErrorContent>
{
    private TestErrorContent content;

    VerifiedTestError()
    {
        content = new TestErrorContent();
    }

    @Override
    public TestErrorContent getContent()
    {
        return content;
    }
}