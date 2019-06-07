package discord.executor;

import discord.components.functionality.command.MessageCommand;
import discord.io.event.MessageReceivedEvent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageReceivedExecutor
{
    private Map<String, MessageCommand> commands;
    private String prefix;

    public MessageReceivedExecutor(String prefix)
    {
        commands = new HashMap<>();
        this.prefix = prefix;
    }

    public void addCommand(MessageCommand command)
    {
        commands.put(command.getName(), command);
    }

    public void execute(MessageReceivedEvent event)
    {
        List<String> content = event.getMessage().getSplitContent();
        if (content.size() == 0)
            return;

        String firstCommand = content.remove(0);
        if (firstCommand.startsWith(prefix))
            firstCommand = removePrefix(firstCommand);

        if (!hasCommand(firstCommand))
            return;

        MessageCommand currentCommand = commands.get(firstCommand);
        while (content.size() > 0)
        {
            String subCommand = content.get(0);
            if (currentCommand.hasSubCommand(subCommand))
            {
                currentCommand = currentCommand.getSubCommand(subCommand);
                content.remove(0);
            }
            else
                break;
        }

        String message = combineContent(content);
        currentCommand.execute(message, event);
    }

    private boolean hasCommand(String name)
    {
        return commands.containsKey(name);
    }

    private String removePrefix(String command)
    {
        return command.substring(prefix.length());
    }

    private String combineContent(List<String> messageContent)
    {
        StringBuilder builder = new StringBuilder();
        for (String portion: messageContent)
        {
            String text = portion + " ";
            builder.append(text);
        }
        if (builder.length() > 0)
            builder.deleteCharAt(builder.length() - 1);

        return builder.toString();
    }
}