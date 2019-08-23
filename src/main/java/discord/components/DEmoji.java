package discord.components;

import org.javacord.api.entity.emoji.CustomEmoji;
import org.javacord.api.entity.emoji.Emoji;
import utility.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DEmoji
{
    private Emoji emoji;
    public static final String YES = "\u2705";
    public static final String NO = "\u274C";

    public DEmoji(Emoji emoji)
    {
        this.emoji = emoji;
    }

    public boolean isDefaultEmoji()
    {
        return emoji.isUnicodeEmoji();
    }

    public boolean isCustomEmoji()
    {
        return emoji.isCustomEmoji();
    }

    public long getId()
    {
        Optional<CustomEmoji> customEmoji = emoji.asCustomEmoji();
        if (customEmoji.isPresent())
            return customEmoji.get().getId();
        else
            return 0;
    }

    public String getName()
    {
        Optional<CustomEmoji> customEmoji = emoji.asCustomEmoji();
        if (customEmoji.isPresent())
            return customEmoji.get().getName();
        else
            return null;
    }

    public String getUnicode()
    {
        Optional<String> unicode = emoji.asUnicodeEmoji();
        if (unicode.isPresent())
            return unicode.get();
        else
            return null;
    }

    public static List<Pair<String, String>> getVerification()
    {
        ArrayList<Pair<String, String>> list = new ArrayList<>();
        list.add(new Pair<>(YES, "yes"));
        list.add(new Pair<>(NO, "no"));
        return list;
    }
}
