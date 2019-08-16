package discord.components.functionality.command;

import discord.components.DChannel;
import discord.components.functionality.verification.ReactionVerifier;
import discord.components.functionality.verification.VerifiedReaction;
import discord.executor.ReactionExecutor;
import discord.io.event.ReactionReceivedEvent;
import discord.io.listener.ReactionReceivedListener;
import utility.Pair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Command to run from reactions
 */
public class ReactionCommand
{
    private Map<String, String> emojiNameMap;
    private ReactionExecutor executor;
    private ReactionVerifier verifier;
    private ReactionReceivedListener listener;
    private DChannel channel;

    public ReactionCommand(List<Pair<String, String>> emojis, ReactionExecutor executor, ReactionVerifier verifier)
    {
        this.emojiNameMap = new HashMap<>();
        this.executor = executor;
        this.verifier = verifier;

        for (Pair<String, String> emoji: emojis)
        {
            emojiNameMap.put(emoji.getKey(), emoji.getValue());
        }
    }

    public void addListener(DChannel channel, ReactionReceivedListener listener)
    {
        this.channel = channel;
        this.listener = listener;
    }

    public void execute(ReactionReceivedEvent event)
    {
        String reaction = emojiNameMap.get(event.getEmoji().getUnicode());
        if (reaction != null)
        {
            VerifiedReaction verifiedReaction = verifier.verifyReaction(event, reaction);
            executor.runCommand(verifiedReaction);
            channel.removeReactionListener(listener);
        }
    }
}