package core.basesyntax.dao.impl;

import core.basesyntax.dao.MessageDao;
import core.basesyntax.model.Message;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class MessageDaoImpl extends AbstractDao implements MessageDao {
    public MessageDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Message create(Message entity) {
        return null;
    }

    @Override
    public Message get(Long id) {
        return null;
    }

    @Override
    public List<Message> getAll(String table) {
        return null;
    }

    @Override
    public void remove(Message entity) {
        Session currentSession = null;
        Transaction transaction = null;
        try {
            currentSession = factory.openSession();
            transaction = currentSession.beginTransaction();
            currentSession.remove(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Can't remove entity " + entity, e);
        } finally {
            if (currentSession != null) {
                currentSession.close();
            }
        }
    }
}
