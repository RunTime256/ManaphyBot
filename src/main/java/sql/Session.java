package sql;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class Session
{
    private String config;
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession session;

    public Session(String config)
    {
        this.config = config;
    }

    public void init() throws IOException
    {
        Reader reader = Resources.getResourceAsReader(config);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    }

    <T> T getMapper(Class<T> aClass)
    {
        session = sqlSessionFactory.openSession();
        return session.getMapper(aClass);
    }

    void close()
    {
        session.commit();
        session.close();
    }
}