import java.io.IOException;

import sql.Session;
import sql.SessionFactory;
import bot.Bot;
import bot.BotMapper;

public class Manaphy
{
    public static void main(String[] args) throws IOException
    {
        SessionFactory.init("mybatis-config.xml");

        Bot bot;

        // Get the bot info from the session
        try (Session session = SessionFactory.getSession())
        {
            //select contact all contacts
            BotMapper mapper = session.getMapper(BotMapper.class);
            bot = mapper.getBot("Zygarde");
        }

        bot.start();
    }
}