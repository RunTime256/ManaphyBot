package bot.command.misc.verifier;

import discord.components.functionality.verification.VerifiedMessage;

/**
 * Creates a verified test error command
 */
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