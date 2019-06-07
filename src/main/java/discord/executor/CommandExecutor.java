package discord.executor;

import discord.components.functionality.verification.VerifiedMessage;

public interface CommandExecutor
{
    void runCommand(VerifiedMessage message);
}