package discord.executor;

import discord.io.event.MessageReceivedEvent;

import java.util.HashMap;
import java.util.Map;

public class MessageReceivedExecutor
{
    private Map<String, CommandExecutor> commands;

    public MessageReceivedExecutor()
    {
        commands = new HashMap<>();
    }

    public void addCommand(String name, CommandExecutor command)
    {
        commands.put(name, command);
    }

    public void execute(MessageReceivedEvent event)
    {

    }
}