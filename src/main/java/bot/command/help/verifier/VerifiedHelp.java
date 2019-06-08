package bot.command.help.verifier;

import discord.components.functionality.verification.VerifiedMessage;

public class VerifiedHelp implements VerifiedMessage<HelpContent>
{
    @Override
    public HelpContent getContent()
    {
        return new HelpContent();
    }
}