package discord.executor;

import discord.io.event.MessageReceivedEvent;

public interface CommandExecutor
{
    void runCommand(MessageReceivedEvent event);
}