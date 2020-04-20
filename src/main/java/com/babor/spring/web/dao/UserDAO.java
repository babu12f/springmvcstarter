package com.babor.spring.web.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Component("userDao")
@Transactional
public class UserDAO {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private SessionFactory sessionFactory;

    public UserDAO() {
    }

    public Session session() {
        return sessionFactory.getCurrentSession();
    }

    public void createUser(User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        session().save(user);
    }

    public boolean exists(String username) {
        Criteria criteria = session().createCriteria(User.class);

//        criteria.add(Restrictions.eq("username", username));
        criteria.add(Restrictions.idEq(username));

        User user = (User) criteria.uniqueResult();

        return user != null;
    }

    @SuppressWarnings("JpaQlInspection")
    public List<User> getAll() {
        return session().createQuery("from User").list();
    }
}
