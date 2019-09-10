package bot.command;

import bot.command.help.HelpCommand;
import bot.command.roles.RoleCommand;
import discord.components.functionality.command.MessageCommand;

import java.util.ArrayList;
import java.util.List;

/**
 * Creates commands for the bot
 */
public class Commands
{
    private RoleCommand roleCommand;

    /**
     * Construct commands
     */
    public Commands()
    {
        roleCommand = new RoleCommand();
    }

    /**
     * Get active commands for the bot
     *
     * @param prefix prefix for the bot commands
     * @return list of all commands
     */
    public List<MessageCommand> getActiveCommands(String prefix)
    {
        List<MessageCommand> commands = new ArrayList<>();
        commands.add(roleCommand.getCommand());
        commands.add(new HelpCommand(commands, prefix).getCommand());

        return commands;
    }

    public List<MessageCommand> getActiveSecretCommands()
    {
        List<MessageCommand> commands = new ArrayList<>();
        return commands;
    }

    public List<MessageCommand> getActiveBotCommands()
    {
        List<MessageCommand> commands = new ArrayList<>();
        return commands;
    }
}