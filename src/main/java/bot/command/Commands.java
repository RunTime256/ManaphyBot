package bot.command;

import bot.command.help.HelpCommand;
import bot.command.roles.RoleCommand;
import discord.components.functionality.command.MessageCommand;

import java.util.ArrayList;
import java.util.List;

public class Commands
{
    private RoleCommand roleCommand;

    public Commands()
    {
        roleCommand = new RoleCommand();
    }

    public List<MessageCommand> getActiveCommands(String prefix)
    {
        List<MessageCommand> commands = new ArrayList<>();
        commands.add(roleCommand.getCommand());
        commands.add(new HelpCommand(commands, prefix).getCommand());

        return commands;
    }
}