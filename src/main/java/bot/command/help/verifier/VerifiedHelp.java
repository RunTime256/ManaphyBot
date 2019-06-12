package bot.command.help.verifier;

import discord.components.functionality.command.MessageCommand;
import discord.components.functionality.verification.VerifiedMessage;
import discord.io.response.MessageResponse;

public class VerifiedHelp implements VerifiedMessage<HelpContent>
{
    private HelpContent content;

    VerifiedHelp(String commandString, MessageCommand command, String exception, MessageResponse sender, String prefix)
    {
        content = new HelpContent(commandString, command, exception, sender, prefix);
    }
    @Override
    public HelpContent getContent()
    {
        return content;
    }
}