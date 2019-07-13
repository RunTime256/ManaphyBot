package bot.command.help.verifier;

import discord.components.functionality.command.MessageCommand;
import discord.components.functionality.verification.VerifiedMessage;
import discord.io.response.MessageResponse;

/**
 * Cretes a verified help command
 */
public class VerifiedHelp implements VerifiedMessage<HelpContent>
{
    private HelpContent content;

    VerifiedHelp(String botName, String commandString, MessageCommand command, String exception, MessageResponse sender, String prefix)
    {
        content = new HelpContent(botName, commandString, command, exception, sender, prefix);
    }

    @Override
    public HelpContent getContent()
    {
        return content;
    }
}