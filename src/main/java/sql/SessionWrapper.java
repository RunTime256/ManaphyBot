package sql;

/**
 * A wrapper for a SQL Session that is AutoCloseable
 */
public class SessionWrapper implements AutoCloseable
{
    private Session session;

    /**
     * Initializes a session
     *
     * @param session The session to wrap
     */
    public SessionWrapper(Session session)
    {
        this.session = session;
    }

    /**
     * Gets the mapper for the session
     *
     * @param aClass The class of the mapper
     * @param <T> The object of the mapper
     * @return The mapper of type T
     */
    public <T> T getMapper(Class<T> aClass)
    {
        return session.getMapper(aClass);
    }

    /**
     * Closes the current session
     */
    @Override
    public void close()
    {
        session.close();
    }
}