package com.babor.spring.web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component("userDao")
public class UserDAO {
    private NamedParameterJdbcTemplate jdbc;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserDAO() {
    }

    @Autowired
    public UserDAO(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }

    @Transactional
    public boolean createUser(User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(user);

        jdbc.update("insert into users (username, email, password, enabled) values (:username, :email, :password, :enabled)", params);

        return jdbc.update("insert into authorities (username, authority) values (:username, :authority)", params) == 1;
    }


    public boolean exists(String username) {
        return jdbc.queryForObject("select count(*) from users where username = :username",
                new MapSqlParameterSource("username", username), Integer.class) > 0;

    }

    public List<User> getAll() {
        return jdbc.query("select * from users, authorities where users.username=authorities.username",
                BeanPropertyRowMapper.newInstance(User.class));
    }
}
