package discord.components.functionality.verification;

import discord.io.event.MessageReceivedEvent;
import exception.bot.command.InvalidArgumentsException;

public interface MessageVerifier<T>
{
    VerifiedMessage<T> verifyMessage(String message, MessageReceivedEvent event) throws InvalidArgumentsException;
}