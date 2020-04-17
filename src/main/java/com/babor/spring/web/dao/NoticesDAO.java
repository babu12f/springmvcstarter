package com.babor.spring.web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.*;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component("noticeDao")
public class NoticesDAO {
    private NamedParameterJdbcTemplate jdbc;

    public NoticesDAO() {
    }

    @Autowired
    public NoticesDAO(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }

    @Transactional
    public int[] createNotice(List<Notice> notices) {
        SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(notices.toArray());

        return jdbc.batchUpdate("insert into notices (username text) values (:username, :text)", params);
    }

    public boolean createNotice(Notice notice) {
        BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(notice);

        return jdbc.update("insert into notices (username, text) values (:username, :text)", params) == 1;
    }

    public List<Notice> getNotices() {

        return jdbc.query("select * from notices, users, authorities where users.username=notices.username and users.username=authorities.username and users.enabled=true", new RowMapper<Notice>() {

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

        });
    }

    public Notice getNoticeById(int id) {

        MapSqlParameterSource params = new MapSqlParameterSource("id", id);

        return jdbc.queryForObject("select * from notices, users, authorities where users.username=notices.username and users.username=authorities.username and users.enabled=true and notices.id = :id", params, new RowMapper<Notice>() {

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

        });
    }

    public boolean updateNotice(Notice notice) {
        BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(notice);

        return jdbc.update("update notices set text = :text where id = :id", params) == 1;
    }

    public Boolean deleteNoticeById(int id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);

        return jdbc.update("delete from notices where id = :id", params) == 1;
    }
}
