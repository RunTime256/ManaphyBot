package bot.command.misc.verifier;

import discord.components.functionality.verification.VerifiedMessage;
import discord.io.response.MessageResponse;

public class VerifiedTestMessage implements VerifiedMessage<TestMessageContent>
{
    private TestMessageContent content;

    VerifiedTestMessage(String message, MessageResponse response)
    {
        content = new TestMessageContent(message, response);
    }

    @Override
    public TestMessageContent getContent()
    {
        return content;
    }
}