package discord.components.functionality.verification;

import discord.components.functionality.Content;
import discord.io.event.ReactionReceivedEvent;

public interface ReactionVerifier<T, C>
{
    VerifiedReaction<T> verifyReaction(ReactionReceivedEvent event, String reaction, Content<C> content);
}
