package bot.command.misc;

import bot.command.misc.verifier.TestContent;
import bot.command.misc.verifier.TestVerifier;
import discord.components.functionality.command.MessageCommand;
import discord.components.functionality.verification.VerifiedMessage;

public class TestCommand
{
    private MessageCommand command;

    public TestCommand()
    {
        command = new MessageCommand("test", "Test a message", (this::execute), new TestVerifier());
    }

    public MessageCommand getCommand()
    {
        return command;
    }

    private void execute(VerifiedMessage<TestContent> message)
    {
        TestContent content = message.getContent();
        String text = content.getMessage();
        content.getSender().sendMessage(text);
    }
}
