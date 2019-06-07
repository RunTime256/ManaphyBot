package bot.command.misc.verifier;

import discord.components.functionality.verification.MessageVerifier;
import discord.components.functionality.verification.VerifiedMessage;
import discord.io.event.MessageReceivedEvent;
import discord.io.response.MessageResponse;

public class TestVerifier implements MessageVerifier<TestContent>
{

    @Override
    public VerifiedMessage<TestContent> verifyMessage(String message, MessageReceivedEvent event)
    {
        return new TestVMessage(message, new MessageResponse(event.getChannel()));
    }
}