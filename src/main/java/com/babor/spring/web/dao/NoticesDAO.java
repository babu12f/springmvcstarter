package com.babor.spring.web.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

@Repository
@Transactional
@Component("noticeDao")
public class NoticesDAO {
    private NamedParameterJdbcTemplate jdbc;

    @Autowired
    private SessionFactory sessionFactory;

    public NoticesDAO() {
    }

    public Session session() {
        return sessionFactory.getCurrentSession();
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

    public void createNotice(Notice notice) {
        session().save(notice);
    }

    public List<Notice> getNotices() {
        Criteria criteria = session().createCriteria(Notice.class);

        criteria.createAlias("user", "u")
                .add(Restrictions.eq("u.enabled", true));

        return criteria.list();
    }

    public Notice getNoticeById(int id) {

        MapSqlParameterSource params = new MapSqlParameterSource("id", id);

        String sql = "select * from notices, users where users.username=notices.username " +
                "and users.enabled=true and notices.id = :id";

        return jdbc.queryForObject(sql, params, new NoticeRowMapper());
    }

    public List<Notice> getNoticeByUsername(String username) {

        String sql = "select * from notices, users where users.username=notices.username " +
                "and users.enabled=true and notices.username = :username";

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
