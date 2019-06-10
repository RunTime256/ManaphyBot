package bot.command.help.verifier;

import discord.components.functionality.command.MessageCommand;
import discord.components.functionality.verification.VerifiedMessage;
import discord.io.response.MessageResponse;

public class VerifiedHelp implements VerifiedMessage<HelpContent>
{
    private HelpContent content;

    VerifiedHelp(MessageCommand command, String exception, MessageResponse sender)
    {
        content = new HelpContent(command, exception, sender);
    }
    @Override
    public HelpContent getContent()
    {
        return content;
    }
}