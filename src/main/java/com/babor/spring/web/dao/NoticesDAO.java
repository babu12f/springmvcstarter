package com.babor.spring.web.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
@Component("noticeDao")
public class NoticesDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public NoticesDAO() {
    }

    public Session session() {
        return sessionFactory.getCurrentSession();
    }

    public void createNotice(Notice notice) {
        session().save(notice);
    }

    public List<Notice> getNotices() {
        Criteria criteria = session().createCriteria(Notice.class);

        return criteria.createAlias("user", "u")
                .add(Restrictions.eq("u.enabled", true))
                .list();
    }

    public Notice getNoticeById(int id) {
        Criteria criteria = session().createCriteria(Notice.class);

        return (Notice) criteria
                .add(Restrictions.idEq(id))
                .uniqueResult();
    }

    public List<Notice> getNoticeByUsername(String username) {
        Criteria criteria = session().createCriteria(Notice.class);

        return criteria.createAlias("user", "u")
                .add(Restrictions.eq("u.enabled", true))
                .add(Restrictions.eq("u.username", username))
                .list();
    }

    public void updateNotice(Notice notice) {
        session().update(notice);
    }

    public void deleteNoticeById(int id) {
        Notice notice = getNoticeById(id);
        session().delete(notice);
    }
}
