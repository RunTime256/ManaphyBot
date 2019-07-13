package discord.components.functionality.verification;

/**
 * Verified command message
 *
 * @param <T> verified content class
 */
public interface VerifiedMessage<T>
{
    T getContent();
}