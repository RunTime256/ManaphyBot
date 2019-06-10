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

public class HelpVerifier extends MessageVerifier<HelpContent>
{
    private String exception;
    private Map<String, MessageCommand> executor;

    public HelpVerifier(Map<String, MessageCommand> executor)
    {
        arguments = new HashMap<>();
        arguments.put("e", (this::extractExceptionArg));
        exception = "";

        this.executor = executor;
    }

    @Override
    public VerifiedMessage<HelpContent> verifyMessage(String message, MessageReceivedEvent event)
    {
        List<String> args = getSplitContent(message);
        MessageCommand command = extractCommand(args);
        extractArgs(args);
        MessageResponse sender = new MessageResponse(event.getChannel());

        return new VerifiedHelp(command, exception, sender);
    }

    private MessageCommand extractCommand(List<String> message)
    {
        List<String> command = new ArrayList<>();

        while (!message.isEmpty())
        {
            String text = message.get(0);
            if (!text.isEmpty())
                if (text.startsWith(ARGUMENT))
                    break;
                else
                    command.add(text);

            message.remove(0);
        }

        return getCommand(command);
    }

    private MessageCommand getCommand(List<String> command)
    {
        MessageCommand current = null;
        while (!command.isEmpty())
            if (executor.containsKey(command.get(0)))
                current = executor.get(command.remove(0));
            else
                break;

        return current;
    }

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