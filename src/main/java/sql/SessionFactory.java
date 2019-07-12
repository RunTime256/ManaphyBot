package sql;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * Creates sessions for SQL statement execution
 */
public class SessionFactory
{
    private static SqlSessionFactory factory;

    private SessionFactory()
    {
    }

    /**
     * Initializes factory with a MyBatis config file
     *
     * @param config file name in resource directory
     * @throws IOException if resource was not found
     */
    public static void init(String config) throws IOException
    {
        Reader reader = Resources.getResourceAsReader(config);
        factory = new SqlSessionFactoryBuilder().build(reader);
    }

    /**
     * Gets a new session for SQL execution
     *
     * @return SQL session
     */
    public static Session getSession()
    {
        return new Session(factory.openSession());
    }
}