package bot.command.misc.verifier;

import exception.bot.command.CommandException;

/**
 * Content for a test error
 */
public class TestErrorContent
{
    private CommandException commandException;

    TestErrorContent()
    {
        commandException = new CommandException("Test Error");
    }

    public CommandException getCommandException()
    {
        return commandException;
    }
}