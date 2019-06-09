package bot.command.misc.verifier;

import discord.components.functionality.verification.MessageVerifier;
import discord.components.functionality.verification.VerifiedMessage;
import discord.io.event.MessageReceivedEvent;
import discord.io.response.MessageResponse;
import exception.bot.command.InvalidArgumentsException;

public class TestMessageVerifier implements MessageVerifier<TestMessageContent>
{
    @Override
    public VerifiedMessage<TestMessageContent> verifyMessage(String message, MessageReceivedEvent event) throws InvalidArgumentsException
    {
        if (message.length() == 0)
            throw new InvalidArgumentsException("Cannot have an empty message!");
        return new VerifiedTestMessage(message, new MessageResponse(event.getChannel()));
    }
}