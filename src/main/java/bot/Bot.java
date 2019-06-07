package bot;

import discord.Discord;

public class Bot
{
    private Discord discord;
    private String name;
    private String token;
    private String prefix;

    public Bot(String name, String token, String prefix)
    {
        super();
        this.name = name;
        this.token = token;
        this.prefix = prefix;
        discord = new Discord(token, prefix);
    }

    public void start()
    {
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