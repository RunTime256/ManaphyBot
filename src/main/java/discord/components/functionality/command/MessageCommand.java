package discord.components.functionality.command;

import discord.components.functionality.verification.MessageVerifier;
import discord.components.functionality.verification.VerifiedMessage;
import discord.executor.CommandExecutor;
import discord.io.event.MessageReceivedEvent;
import exception.bot.command.CommandException;
import exception.bot.command.InvalidArgumentsException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageCommand
{
    private String name;
    private String description;
    private String syntax;
    private Map<String, MessageCommand> subCommands;
    private MessageCommand parent;
    private CommandExecutor executor;
    private MessageVerifier verifier;

    public MessageCommand(String name, String description, CommandExecutor executor, MessageVerifier verifier)
    {
        this.subCommands = new HashMap<>();

        this.name = name;
        this.description = description;
        this.syntax = "";
        this.executor = executor;
        this.verifier = verifier;
        this.parent = null;
    }

    public MessageCommand(String name, String description, String syntax, CommandExecutor executor, MessageVerifier verifier)
    {
        this.subCommands = new HashMap<>();

        this.name = name;
        this.description = description;
        this.syntax = syntax;
        this.executor = executor;
        this.verifier = verifier;
        this.parent = null;
    }

    public MessageCommand(String name, String description, List<MessageCommand> subCommands, CommandExecutor executor, MessageVerifier verifier)
    {
        this.subCommands = new HashMap<>();

        this.name = name;
        this.description = description;
        this.syntax = "";
        this.executor = executor;
        this.verifier = verifier;

        for (MessageCommand subCommand: subCommands)
        {
            this.subCommands.put(subCommand.getName(), subCommand);
            subCommand.setParent(this);
        }
    }

    public MessageCommand(String name, String description, String syntax, List<MessageCommand> subCommands, CommandExecutor executor, MessageVerifier verifier)
    {
        this.subCommands = new HashMap<>();

        this.name = name;
        this.description = description;
        this.syntax = syntax;
        this.executor = executor;
        this.verifier = verifier;

        for (MessageCommand subCommand: subCommands)
        {
            this.subCommands.put(subCommand.getName(), subCommand);
            subCommand.setParent(this);
        }
    }

    public MessageCommand(String name, String description, List<MessageCommand> subCommands)
    {
        this.subCommands = new HashMap<>();

        this.name = name;
        this.description = description;
        this.syntax = "";
        this.executor = null;
        this.verifier = null;

        for (MessageCommand subCommand: subCommands)
        {
            this.subCommands.put(subCommand.getName(), subCommand);
            subCommand.setParent(this);
        }
    }

    public String getFullName()
    {
        StringBuilder builder = new StringBuilder();
        MessageCommand current = this;
        while (current != null)
        {
            String spacedName = " " + current.getName();
            builder.insert(0, spacedName);
            current = current.getParent();
        }
        builder.deleteCharAt(0);

        return builder.toString();
    }

    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }

    public String getSyntax()
    {
        return syntax;
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

    private MessageCommand getParent()
    {
        return parent;
    }

    public void execute(String message, MessageReceivedEvent event) throws CommandException
    {
        if (executor == null || verifier == null)
        {
            String response = "This command does not do anything.";
            if (!subCommands.isEmpty())
                response += " Please use a sub-command.";
            throw new InvalidArgumentsException(response);
        }

        VerifiedMessage verifiedMessage = verifier.verifyMessage(message, event);
        executor.runCommand(verifiedMessage);
    }

    private void setParent(MessageCommand parent)
    {
        this.parent = parent;
    }
}