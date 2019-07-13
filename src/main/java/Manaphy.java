import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sql.Session;
import sql.SessionFactory;
import bot.Bot;
import bot.BotMapper;

public class Manaphy
{
    private static final Logger logger = LogManager.getLogger(Manaphy.class);

    public static void main(String[] args) throws IOException
    {
        if (args.length < 1)
        {
            logger.error("Provide bot name as argument");
            return;
        }

        String botName = args[0];

        SessionFactory.init("mybatis-config.xml");

        Bot bot;

        // Get the bot info from the session
        try (Session session = SessionFactory.getSession())
        {
            //select contact all contacts
            BotMapper mapper = session.getMapper(BotMapper.class);
            bot = mapper.getBot(botName);
        }

        bot.start();
    }
}