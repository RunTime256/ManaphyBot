package discord.components;

import org.javacord.api.entity.message.Reaction;
import org.javacord.api.entity.user.User;

import java.util.ArrayList;
import java.util.List;

public class DReaction
{
    private Reaction reaction;

    public DReaction(Reaction reaction)
    {
        this.reaction = reaction;
    }

    public DEmoji getEmoji()
    {
        return new DEmoji(reaction.getEmoji());
    }

    public List<DUser> getUsers()
    {
        List<DUser> users = new ArrayList<>();
        for (User user: reaction.getUsers().join())
        {
            users.add(new DUser(user));
        }
        return users;
    }
}