package bot.command.misc;

import bot.command.misc.verifier.TestErrorContent;
import bot.command.misc.verifier.TestErrorVerifier;
import bot.command.misc.verifier.TestMessageContent;
import bot.command.misc.verifier.TestMessageVerifier;
import discord.components.functionality.command.MessageCommand;
import discord.components.functionality.verification.VerifiedMessage;
import exception.bot.command.CommandException;

import java.util.ArrayList;
import java.util.List;

public class TestCommand
{
    private MessageCommand command;

    public TestCommand()
    {
        command = createTestCommand();
    }

    public MessageCommand getCommand()
    {
        return command;
    }

    private MessageCommand createTestCommand()
    {
        List<MessageCommand> subCommands = new ArrayList<>();
        subCommands.add(createTestMessageCommand());
        subCommands.add(createTestErrorCommand());

        return new MessageCommand("test", "Test something", subCommands);
    }

    private MessageCommand createTestMessageCommand()
    {
        return new MessageCommand("message", "Test a message response", "<message>", (this::testMessage), new TestMessageVerifier());
    }

    private MessageCommand createTestErrorCommand()
    {
        return new MessageCommand("error", "Test an error response", (this::testError), new TestErrorVerifier());
    }

    private void testMessage(VerifiedMessage<TestMessageContent> message)
    {
        TestMessageContent content = message.getContent();
        String text = content.getMessage();
        content.getSender().sendMessage(text);
    }

    private void testError(VerifiedMessage<TestErrorContent> message) throws CommandException
    {
        TestErrorContent content = message.getContent();
        throw content.getCommandException();
    }
}