package discord.executor;

import discord.components.functionality.verification.VerifiedReaction;

public interface ReactionExecutor
{
    void runCommand(VerifiedReaction reaction);
}