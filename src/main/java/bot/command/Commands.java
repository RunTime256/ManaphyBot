package bot.command;

import bot.command.misc.TestCommand;
import discord.components.functionality.command.MessageCommand;

import java.util.ArrayList;
import java.util.List;

public class Commands
{
    public Commands()
    {

    }

    public List<MessageCommand> getActiveCommands()
    {
        List<MessageCommand> commands = new ArrayList<>();
        TestCommand testCommand = new TestCommand();

        commands.add(testCommand.getCommand());

        return commands;
    }
}