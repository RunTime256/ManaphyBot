package bot.command;

import bot.command.help.HelpCommand;
import bot.command.misc.TestCommand;
import discord.components.functionality.command.MessageCommand;

import java.util.ArrayList;
import java.util.List;

public class Commands
{
    private HelpCommand helpCommand;
    private TestCommand testCommand;
    public Commands()
    {
        helpCommand = new HelpCommand();
        testCommand = new TestCommand();
    }

    public List<MessageCommand> getActiveCommands()
    {
        List<MessageCommand> commands = new ArrayList<>();
        commands.add(testCommand.getCommand());
        commands.add(helpCommand.getCommand());

        return commands;
    }
}