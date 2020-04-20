package com.babor.spring.web.test.tests;

import com.babor.spring.web.dao.User;
import com.babor.spring.web.dao.UserDAO;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class UserDaoTests extends BaseTests {

    @Autowired
    private UserDAO usersDao;

    @Before
    public void init() {
        super.init();
    }

    @Test
    public void testCreateUser() {

        User user = new User("admin", "shofiullah babor", "babu@gmal.com", "secret", true, "ROLE_ADMIN");

        usersDao.createUser(user);

        List<User> users = usersDao.getAll();

        assertEquals("Number of users should be 1.", 1, users.size());

        assertTrue("User should exist.", usersDao.exists(user.getUsername()));

        assertEquals("Created user should be identical to retrived user", user, users.get(0));

    }

//    @Test
//    public void testCreateUser() {
//        User user = new User("admin", "shofiullah babor", "babu@gmal.com", "secret", true, "ROLE_ADMIN");
//
//        assertTrue("User creation should return true", usersDao.createUser(user));
//    }

    @Test
    public void testCountUser() {
        User user = new User("admin", "shofiullah babor", "babu@gmal.com", "secret", true, "ROLE_ADMIN");
        usersDao.createUser(user);

        assertEquals("User count", 1, usersDao.getAll().size());
    }

    @Test
    public void testDummy() {
        assertEquals("Dummy test", 1, 1);
    }
}
