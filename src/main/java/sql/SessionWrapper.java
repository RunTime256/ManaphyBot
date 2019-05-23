package sql;

public class SessionWrapper implements AutoCloseable
{
    private Session session;

    public SessionWrapper(Session session)
    {
        this.session = session;
    }

    public <T> T getMapper(Class<T> aClass)
    {
        return session.getMapper(aClass);
    }

    @Override
    public void close()
    {
        session.close();
    }
}