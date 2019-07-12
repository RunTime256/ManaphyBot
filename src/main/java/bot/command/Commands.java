package bot.command;

import bot.command.help.HelpCommand;
import bot.command.misc.TestCommand;
import discord.components.functionality.command.MessageCommand;

import java.util.ArrayList;
import java.util.List;

/**
 * Creates commands for the bot
 */
public class Commands
{
    private TestCommand testCommand;

    /**
     * Construct commands
     */
    public Commands()
    {
        testCommand = new TestCommand();
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
        commands.add(testCommand.getCommand());
        commands.add(new HelpCommand(commands, prefix).getCommand());

        return commands;
    }
}