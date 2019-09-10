package discord.components.functionality;

public class Content<C>
{
    private C content;

    public Content(C content)
    {
        this.content = content;
    }

    public C getContent()
    {
        return content;
    }
}