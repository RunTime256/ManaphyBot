package bot.command.help.verifier;

import discord.components.functionality.verification.MessageVerifier;
import discord.components.functionality.verification.VerifiedMessage;
import discord.io.event.MessageReceivedEvent;

public class HelpVerifier implements MessageVerifier<HelpContent>
{
    @Override
    public VerifiedMessage<HelpContent> verifyMessage(String message, MessageReceivedEvent event)
    {
        return new VerifiedHelp();
    }
}