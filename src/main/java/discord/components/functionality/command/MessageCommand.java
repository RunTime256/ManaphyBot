package discord.components.functionality.command;

import discord.components.functionality.verification.MessageVerifier;
import discord.components.functionality.verification.VerifiedMessage;
import discord.executor.CommandExecutor;
import discord.io.event.MessageReceivedEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageCommand
{
    private String name;
    private String description;
    private Map<String, MessageCommand> subCommands;
    private CommandExecutor executor;
    private MessageVerifier verifier;

    public MessageCommand(String name, String description, CommandExecutor executor, MessageVerifier verifier)
    {
        this.subCommands = new HashMap<>();

        this.name = name;
        this.description = description;
        this.executor = executor;
        this.verifier = verifier;
    }

    public MessageCommand(String name, String description, List<MessageCommand> subCommands, CommandExecutor executor, MessageVerifier verifier)
    {
        this.subCommands = new HashMap<>();

        this.name = name;
        this.description = description;
        this.executor = executor;
        this.verifier = verifier;

        for (MessageCommand subCommand: subCommands)
        {
            this.subCommands.put(subCommand.getName(), subCommand);
        }
    }

    public MessageCommand(String name, String description, List<MessageCommand> subCommands)
    {
        this.subCommands = new HashMap<>();

        this.name = name;
        this.description = description;
        this.executor = null;
        this.verifier = null;

        for (MessageCommand subCommand: subCommands)
        {
            this.subCommands.put(subCommand.getName(), subCommand);
        }
    }

    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }

    public List<String> getSubCommands()
    {
        return new ArrayList<>(subCommands.keySet());
    }

    public boolean hasSubCommand(String name)
    {
        return subCommands.containsKey(name);
    }

    public MessageCommand getSubCommand(String name)
    {
        return subCommands.get(name);
    }

    public void execute(String message, MessageReceivedEvent event)
    {
        VerifiedMessage verifiedMessage = verifier.verifyMessage(message, event);
        executor.runCommand(verifiedMessage);
    }
}