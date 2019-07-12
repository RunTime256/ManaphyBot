package bot.command.misc.verifier;

import discord.components.functionality.verification.MessageVerifier;
import discord.components.functionality.verification.VerifiedMessage;
import discord.io.event.MessageReceivedEvent;
import discord.io.response.MessageResponse;
import exception.bot.command.InvalidArgumentsException;

/**
 * Verifies a test message command
 */
public class TestMessageVerifier extends MessageVerifier<TestMessageContent>
{
    @Override
    public VerifiedMessage<TestMessageContent> verifyMessage(String message, MessageReceivedEvent event) throws InvalidArgumentsException
    {
        String vMessage = verifyMessage(message);
        return new VerifiedTestMessage(vMessage, new MessageResponse(event.getChannel()));
    }

    /**
     * Verifies message content
     *
     * @param message message to pull message from
     * @return message to return
     * @throws InvalidArgumentsException if the message is empty
     */
    private String verifyMessage(String message) throws InvalidArgumentsException
    {
        if (message.length() == 0)
            throw new InvalidArgumentsException("Cannot have an empty message!");

        return message;
    }
}