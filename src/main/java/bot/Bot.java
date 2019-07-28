package bot;

import bot.command.Commands;
import discord.Discord;

/**
 * Bot that connects to Discord
 */
public class Bot
{
    private Discord discord;
    private String name;
    private String token;
    private String prefix;
    private Commands commands;

    /**
     * Construct bot with name, token, and prefix
     *
     * @param name name of the bot
     * @param token token for bot
     * @param prefix command prefix
     */
    public Bot(String name, String token, String prefix)
    {
        super();
        this.name = name;
        this.prefix = prefix;
        commands = new Commands();
        discord = new Discord(token, prefix, "=");
    }

    /**
     * Start up bot with Discord
     */
    public void start()
    {
        discord.addCommands(commands.getActiveCommands(prefix));
        discord.addSecretCommands(commands.getActiveSecretCommands());
        discord.addBotCommands(commands.getActiveBotCommands());
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