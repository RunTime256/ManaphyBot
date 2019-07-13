package discord.executor;

import discord.components.functionality.verification.VerifiedMessage;
import exception.bot.command.CommandException;

/**
 * Executes commands
 */
public interface CommandExecutor
{
    /**
     * Execute a command
     *
     * @param message verified message
     * @throws CommandException if an exception occurs while executing the command
     */
    void runCommand(VerifiedMessage message) throws CommandException;
}