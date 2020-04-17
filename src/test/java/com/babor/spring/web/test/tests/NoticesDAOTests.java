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

        assertTrue("User creation should return true", usersDao.createUser(user));

        Notice notice = new Notice(user, "This is a test notice.");

        assertTrue("Notice creation should return true", noticesDAO.createNotice(notice));

        List<Notice> notices = noticesDAO.getNotices();

        assertEquals("Should be one offer in database.", 1, notices.size());

        assertEquals("Retrieved notice should match created notice.", notice, notices.get(0));

        // Get the notice with ID filled in.
        notice = notices.get(0);

        notice.setText("Updated offer text.");
        assertTrue("Notice update should return true", noticesDAO.updateNotice(notice));

        Notice updated = noticesDAO.getNoticeById(notice.getId());

        assertEquals("Updated notice should match retrieved updated notice", notice, updated);

        noticesDAO.deleteNoticeById(notice.getId());

        List<Notice> empty = noticesDAO.getNotices();

        assertEquals("Notices lists should be empty.", 0, empty.size());
    }

}
