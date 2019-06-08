package bot.command.misc.verifier;

import discord.components.functionality.verification.MessageVerifier;
import discord.components.functionality.verification.VerifiedMessage;
import discord.io.event.MessageReceivedEvent;
import discord.io.response.MessageResponse;

public class TestErrorVerifier implements MessageVerifier<TestErrorContent>
{
    @Override
    public VerifiedMessage<TestErrorContent> verifyMessage(String message, MessageReceivedEvent event)
    {
        return new TestVError(new MessageResponse(event.getChannel()));
    }
}