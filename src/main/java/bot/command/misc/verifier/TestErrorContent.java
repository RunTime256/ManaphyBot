package bot.command.misc.verifier;

import exception.bot.command.CommandException;

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