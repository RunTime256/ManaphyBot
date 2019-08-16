package discord.components.functionality.verification;

import discord.io.event.ReactionReceivedEvent;

public interface ReactionVerifier<T>
{
    VerifiedReaction<T> verifyReaction(ReactionReceivedEvent event, String reaction);
}