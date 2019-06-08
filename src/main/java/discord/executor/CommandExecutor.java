package discord.executor;

import discord.components.functionality.verification.VerifiedMessage;
import exception.bot.command.CommandException;

public interface CommandExecutor
{
    void runCommand(VerifiedMessage message) throws CommandException;
}