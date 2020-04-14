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

        return jdbc.batchUpdate("insert into notices (id, name, email, text) values (:id, :name, :email, :text)", params);
    }

    public boolean createNotice(Notice notice) {
        BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(notice);

        return jdbc.update("insert into notices (name, email, text) values (:name, :email, :text)", params) == 1;
    }

    public List<Notice> getNotices() {

        return jdbc.query("select * from notices", new RowMapper<Notice>() {

            public Notice mapRow(ResultSet resultSet, int i) throws SQLException {
                Notice notice = new Notice();

                notice.setId(resultSet.getInt("id"));
                notice.setName(resultSet.getString("name"));
                notice.setEmail(resultSet.getString("email"));
                notice.setText(resultSet.getString("text"));

                return notice;
            }

        });
    }

    public Notice getNoticeById(int id) {

        MapSqlParameterSource params = new MapSqlParameterSource("id", id);

        return jdbc.queryForObject("select * from notices where id = :id", params, new RowMapper<Notice>() {

            public Notice mapRow(ResultSet resultSet, int i) throws SQLException {
                Notice notice = new Notice();

                notice.setId(resultSet.getInt("id"));
                notice.setName(resultSet.getString("name"));
                notice.setEmail(resultSet.getString("email"));
                notice.setText(resultSet.getString("text"));

                return notice;
            }

        });
    }

    public boolean updateNotice(Notice notice) {
        BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(notice);

        return jdbc.update("update notices set name = :name, email = :email, text = :text where id = :id", params) == 1;
    }

    public Boolean deleteNoticeById(int id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);

        return jdbc.update("delete from notices where id = :id", params) == 1;
    }
}
