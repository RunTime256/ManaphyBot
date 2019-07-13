package sql;

import org.apache.ibatis.session.SqlSession;

/**
 *
 */
public class Session implements AutoCloseable
{
    private SqlSession session;

    /**
     *  Create session with a SQL session
     *
     * @param session SQL session
     */
    Session(SqlSession session)
    {
        this.session = session;
    }

    /**
     * Gets mapper from the session
     *
     * @param classMap mapper class
     * @param <T> type of the mapper
     * @return SQL mapper
     */
    public <T> T getMapper(Class<T> classMap)
    {
        return session.getMapper(classMap);
    }

    /**
     * Closes the session. Best used with "try with resources"
     */
    @Override
    public void close()
    {
        session.commit();
        session.close();
    }
}