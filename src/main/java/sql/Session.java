package sql;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * A SQL Session
 */
public class Session
{
    private String config;
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession session;

    /**
     * Configures the session
     *
     * @param config The configuration for the session
     */
    public Session(String config)
    {
        this.config = config;
    }

    /**
     * Initializes the SQL session
     *
     * @throws IOException if the config file could not be found
     */
    public void init() throws IOException
    {
        Reader reader = Resources.getResourceAsReader(config);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    }

    /**
     * Gets the mapper for the session
     *
     * @param aClass The class of the mapper
     * @param <T> The object of the mapper
     * @return The mapper of type T
     */
    <T> T getMapper(Class<T> aClass)
    {
        session = sqlSessionFactory.openSession();
        return session.getMapper(aClass);
    }

    /**
     * Closes the session
     */
    void close()
    {
        session.commit();
        session.close();
    }
}