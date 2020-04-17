package com.babor.spring.web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.*;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
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

        String sql = "select * from notices, users, authorities where users.username=notices.username " +
                "and users.username=authorities.username and users.enabled=true";

        return jdbc.query(sql,new NoticeRowMapper());
    }

    public Notice getNoticeById(int id) {

        MapSqlParameterSource params = new MapSqlParameterSource("id", id);

        String sql = "select * from notices, users, authorities where users.username=notices.username " +
                "and users.username=authorities.username and users.enabled=true and notices.id = :id";

        return jdbc.queryForObject(sql, params, new NoticeRowMapper());
    }

    public List<Notice> getNoticeByUsername(String username) {

        String sql = "select * from notices, users, authorities where users.username=notices.username " +
                "and users.username=authorities.username and users.enabled=true and notices.username = :username";

        return jdbc.query(sql, new MapSqlParameterSource("username", username), new NoticeRowMapper());
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
