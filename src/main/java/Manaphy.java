import java.io.IOException;

import sql.Session;
import sql.SessionWrapper;
import bot.Bot;
import bot.BotMapper;

public class Manaphy
{
    public static void main(String[] args) throws IOException
    {
        Session session = new Session("mybatis-config.xml");
        session.init();

        try (SessionWrapper wrapper = new SessionWrapper(session))
        {
            //select contact all contacts
            BotMapper mapper = wrapper.getMapper(BotMapper.class);
            Bot bot = mapper.getBot("Manaphy");
        }
    }
}
