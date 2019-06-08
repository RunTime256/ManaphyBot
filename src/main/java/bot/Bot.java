package bot;

import bot.command.Commands;
import discord.Discord;

public class Bot
{
    private Discord discord;
    private String name;
    private String token;
    private String prefix;
    private Commands commands;

    public Bot(String name, String token, String prefix)
    {
        super();
        this.name = name;
        this.token = token;
        this.prefix = prefix;
        commands = new Commands();
        discord = new Discord(token, prefix, "=");
    }

    public void start()
    {
        discord.addCommands(commands.getActiveCommands());
        discord.start();
    }

    public String getName()
    {
        return name;
    }

    public String getPrefix()
    {
        return prefix;
    }
}