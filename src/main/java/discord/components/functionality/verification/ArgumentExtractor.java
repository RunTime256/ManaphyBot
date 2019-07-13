package discord.components.functionality.verification;

import java.util.List;

/**
 * Extracts arguments
 */
public interface ArgumentExtractor
{
    /**
     * Extract argument
     *
     * @param args list of arguments
     */
    void extractArg(List<String> args);
}