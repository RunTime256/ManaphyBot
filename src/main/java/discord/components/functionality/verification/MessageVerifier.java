package discord.components.functionality.verification;

import discord.io.event.MessageReceivedEvent;

public interface MessageVerifier<T>
{
    VerifiedMessage<T> verifyMessage(String message, MessageReceivedEvent event);
}