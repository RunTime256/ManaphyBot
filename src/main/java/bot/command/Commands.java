package bot.command;

import bot.command.help.HelpCommand;
import bot.command.misc.TestCommand;
import discord.components.functionality.command.MessageCommand;

import java.util.ArrayList;
import java.util.List;

public class Commands
{
    private TestCommand testCommand;

    public Commands()
    {
        testCommand = new TestCommand();
    }

    public List<MessageCommand> getActiveCommands(String prefix)
    {
        List<MessageCommand> commands = new ArrayList<>();
        commands.add(testCommand.getCommand());
        commands.add(new HelpCommand(commands, prefix).getCommand());

        return commands;
    }
}