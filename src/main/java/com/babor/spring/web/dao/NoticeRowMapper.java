package com.babor.spring.web.dao;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NoticeRowMapper implements RowMapper<Notice> {

    @Override
    public Notice mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setUsername(resultSet.getString("username"));
        user.setName(resultSet.getString("name"));
        user.setEmail(resultSet.getString("email"));
        user.setEnabled(true);
        user.setAuthority(resultSet.getString("authority"));

        Notice notice = new Notice();
        notice.setId(resultSet.getInt("id"));
        notice.setText(resultSet.getString("text"));
        notice.setUser(user);

        return notice;
    }
}
