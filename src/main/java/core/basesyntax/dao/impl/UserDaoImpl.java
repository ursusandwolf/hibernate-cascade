package core.basesyntax.dao.impl;

import core.basesyntax.dao.UserDao;
import core.basesyntax.model.Comment;
import core.basesyntax.model.User;
import org.hibernate.SessionFactory;

public class UserDaoImpl extends AbstractDao<User> implements UserDao {
    public UserDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory, User.class);
    }

    @Override
    public void remove(User user) {
        for (Comment c : user.getComments()) {
            c.setUser(null);
        }
        super.remove(user);
    }
}
