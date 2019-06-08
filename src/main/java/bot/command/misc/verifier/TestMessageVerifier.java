package bot.command.misc.verifier;

import discord.components.functionality.verification.MessageVerifier;
import discord.components.functionality.verification.VerifiedMessage;
import discord.io.event.MessageReceivedEvent;
import discord.io.response.MessageResponse;

public class TestMessageVerifier implements MessageVerifier<TestMessageContent>
{
    @Override
    public VerifiedMessage<TestMessageContent> verifyMessage(String message, MessageReceivedEvent event)
    {
        return new VerifiedTestMessage(message, new MessageResponse(event.getChannel()));
    }
}