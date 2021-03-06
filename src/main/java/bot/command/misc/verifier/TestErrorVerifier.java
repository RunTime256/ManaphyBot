package bot.command.misc.verifier;

import discord.components.functionality.verification.MessageVerifier;
import discord.components.functionality.verification.VerifiedMessage;
import discord.io.event.MessageReceivedEvent;

/**
 * Verifies a test error command
 */
public class TestErrorVerifier extends MessageVerifier<TestErrorContent>
{
    public VerifiedMessage<TestErrorContent> verifyMessage(String message, MessageReceivedEvent event)
    {
        return new VerifiedTestError();
    }
}