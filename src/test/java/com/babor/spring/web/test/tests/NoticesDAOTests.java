package com.babor.spring.web.test.tests;

import static org.junit.Assert.*;

import com.babor.spring.web.dao.Notice;
import com.babor.spring.web.dao.NoticesDAO;
import com.babor.spring.web.dao.User;
import com.babor.spring.web.dao.UserDAO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class NoticesDAOTests extends  BaseTests {
    @Autowired
    private NoticesDAO noticesDAO;

    @Autowired
    private UserDAO usersDao;

//    @Test
//    public void testCreateUser() {
//        User user = new User("admin", "shofiullah babor", "babu@gmal.com", "secret", true, "ROLE_ADMIN");
//        //usersDao.createUser(user);
//
//        Notice notice = new Notice(user, "my First notice about the startup");
//
//        assertTrue("Notice creation should return true", noticesDAO.createNotice(notice));
//    }

    @Test
    public void testNotices() {

        User user = new User("admin", "shofiullah babor", "babu@gmal.com", "secret", true, "ROLE_ADMIN");

        usersDao.createUser(user);

        Notice notice = new Notice(user, "This is a test notice.");

        noticesDAO.createNotice(notice);

        List<Notice> notices = noticesDAO.getNotices();

        assertEquals("Should be one offer in database.", 1, notices.size());

        assertEquals("Retrieved notice should match created notice.", notice, notices.get(0));

        // Get the notice with ID filled in.
        notice = notices.get(0);

        notice.setText("Updated offer text.");
        noticesDAO.updateNotice(notice);

        Notice updated = noticesDAO.getNoticeById(notice.getId());

        assertEquals("Updated notice should match retrieved updated notice", notice, updated);

        Notice notice2 = new Notice(user, "This is a test notice. Hello from test notice.");

        noticesDAO.createNotice(notice2);

        List<Notice> userNotices = noticesDAO.getNoticeByUsername(user.getUsername());

        assertEquals("Should be two notices for user.", 2, userNotices.size());

        noticesDAO.deleteNoticeById(userNotices.get(0).getId());
        noticesDAO.deleteNoticeById(userNotices.get(1).getId());

        List<Notice> empty = noticesDAO.getNotices();

        assertEquals("Notices lists should be empty.", 0, empty.size());
    }

}
