package discord.components.functionality.verification;

import discord.io.event.MessageReceivedEvent;
import exception.bot.command.InvalidArgumentsException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Verifier for messages
 *
 * @param <T> verified content class
 */
public abstract class MessageVerifier<T>
{
    public static final String ARGUMENT = "::";
    protected Map<String, ArgumentExtractor> arguments;

    public abstract VerifiedMessage<T> verifyMessage(String message, MessageReceivedEvent event) throws InvalidArgumentsException;

    /**
     * Splits message content
     *
     * @param message message to split
     * @return list of split content
     */
    protected List<String> getSplitContent(String message)
    {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, message.split(" "));

        return list;
    }

    /**
     * Combines message content
     *
     * @param message list of split content
     * @return list of combined content
     */
    protected String combineContent(List<String> message)
    {
        StringBuilder builder = new StringBuilder();
        for (String content: message)
        {
            String add = content + " ";
            builder.append(add);
        }

        if (builder.length() > 0)
            builder.deleteCharAt(builder.length() - 1);

        return builder.toString();
    }

    /**
     * Removes prefix from argument
     *
     * @param arg argument
     * @return argument without prefix
     */
    protected String removeArgumentPrefix(String arg)
    {
        return arg.substring(ARGUMENT.length());
    }
}