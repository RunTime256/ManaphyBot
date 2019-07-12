package bot.command.help.verifier;

import discord.components.functionality.command.MessageCommand;
import discord.components.functionality.verification.ArgumentExtractor;
import discord.components.functionality.verification.MessageVerifier;
import discord.components.functionality.verification.VerifiedMessage;
import discord.io.event.MessageReceivedEvent;
import discord.io.response.MessageResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Verifies a help command
 */
public class HelpVerifier extends MessageVerifier<HelpContent>
{
    private String prefix;
    private String exception;
    private String commandString;
    private Map<String, MessageCommand> executor;

    /**
     * Construct verifier with commands and prefix
     *
     * @param executor bot commands
     * @param prefix bot prefix
     */
    public HelpVerifier(Map<String, MessageCommand> executor, String prefix)
    {
        arguments = new HashMap<>();
        arguments.put("e", (this::extractExceptionArg));
        exception = "";
        commandString = "";
        this.prefix = prefix;

        this.executor = executor;
    }

    @Override
    public VerifiedMessage<HelpContent> verifyMessage(String message, MessageReceivedEvent event)
    {
        List<String> args = getSplitContent(message);
        MessageCommand command = extractCommand(args);
        extractArgs(args);
        MessageResponse sender = new MessageResponse(event.getChannel());
        String botName = event.getApi().getBot().getName();

        return new VerifiedHelp(botName, commandString, command, exception, sender, prefix);
    }

    /**
     * Extract command from command name
     *
     * @param message command name arguments
     * @return command from arguments
     */
    private MessageCommand extractCommand(List<String> message)
    {
        List<String> command = new ArrayList<>();

        while (!message.isEmpty())
        {
            String text = message.get(0);
            if (!text.isEmpty())
            {
                if (!text.startsWith(ARGUMENT))
                {
                    command.add(text);
                }
                else
                {
                    break;
                }
            }

            message.remove(0);
        }

        return getCommand(command);
    }

    /**
     * Gets command from command name
     *
     * @param command command name arguments
     * @return command from arguments
     */
    private MessageCommand getCommand(List<String> command)
    {
        MessageCommand current = null;

        StringBuilder builder = new StringBuilder();

        if (!command.isEmpty())
        {
            String comm = command.remove(0);

            current = executor.get(comm);
            comm = comm + " ";
            builder.append(comm);
        }
        if (current == null)
            return null;

        while (!command.isEmpty())
        {
            String comm = command.remove(0);
            if (!current.hasSubCommand(comm))
                break;

            current = current.getSubCommand(comm);
            comm = comm + " ";
            builder.append(comm);
        }

        if (builder.length() > 0)
            builder.deleteCharAt(builder.length() - 1);
        commandString = builder.toString();

        return current;
    }

    /**
     * Extracts argument for command names
     *
     * @param args remaining arguments
     */
    private void extractArgs(List<String> args)
    {
        while(!args.isEmpty())
        {
            if (args.get(0).startsWith(ARGUMENT))
            {
                String arg = args.remove(0);
                ArgumentExtractor extractor = arguments.get(removeArgumentPrefix(arg));
                extractor.extractArg(args);
            }
        }
    }

    /**
     * Extracts argument for exceptions
     *
     * @param args remaining command arguments
     */
    private void extractExceptionArg(List<String> args)
    {
        StringBuilder builder = new StringBuilder();

        while (!args.isEmpty())
        {
            if (args.get(0).startsWith(ARGUMENT))
                break;

            String arg = args.remove(0) + " ";
            builder.append(arg);
        }

        builder.deleteCharAt(builder.length() - 1);
        exception = builder.toString();
    }
}