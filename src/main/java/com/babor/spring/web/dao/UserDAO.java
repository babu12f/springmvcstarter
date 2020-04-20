package com.babor.spring.web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

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

//    @Autowired
//    public UserDAO(DataSource dataSource) {
//        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
//    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }

    public Session session() {
        return sessionFactory.getCurrentSession();
    }

    @Transactional
    public boolean createUser(User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(user);

        return jdbc.update("insert into users (username, name, email, password, enabled, authority) values (:username, :name, :email, :password, :enabled, :authority)", params) == 1;
    }


    public boolean exists(String username) {
        return jdbc.queryForObject("select count(*) from users where username = :username",
                new MapSqlParameterSource("username", username), Integer.class) > 0;

    }

    @SuppressWarnings({"UnnecessaryLocalVariable", "unchecked"})
    public List<User> getAll() {
        return session().createQuery("from User").list();
    }
}
