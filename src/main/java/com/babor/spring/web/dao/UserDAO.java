package com.babor.spring.web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

@Repository
@Component("userDao")
@Transactional
public class UserDAO {
    private NamedParameterJdbcTemplate jdbc;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private SessionFactory sessionFactory;

    public UserDAO() {
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }

    public Session session() {
        return sessionFactory.getCurrentSession();
    }

    public void createUser(User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        session().save(user);
    }


    public boolean exists(String username) {
        return jdbc.queryForObject("select count(*) from users where username = :username",
                new MapSqlParameterSource("username", username), Integer.class) > 0;

    }

    @SuppressWarnings({"UnnecessaryLocalVariable", "unchecked"})
    public List<User> getAll() {
        return session().createQuery("from User3").list();
    }
}
