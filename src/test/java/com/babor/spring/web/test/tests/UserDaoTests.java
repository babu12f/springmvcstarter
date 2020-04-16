package com.babor.spring.web.test.tests;

import static org.junit.Assert.*;
import com.babor.spring.web.dao.User;
import com.babor.spring.web.dao.UserDAO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

import static org.junit.Assert.assertEquals;

@ActiveProfiles("dev")
@ContextConfiguration(locations = {
        "classpath:dao-context.xml",
        "classpath:security-context.xml",
        "classpath:datasource.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDaoTests {

    @Autowired
    private UserDAO usersDao;

    @Autowired
    private DataSource dataSource;

    @Before
    public void init() {
        JdbcTemplate jdbc = new JdbcTemplate(dataSource);

        jdbc.execute("truncate users");
        jdbc.execute("truncate authorities");
    }

    @Test
    public void testCreateUser() {
        User user = new User("babor", "babu@gmal.com", "secret", true, "ROLE_ADMIN");

        assertTrue("User creation should return true", usersDao.createUser(user));
    }

    @Test
    public void testCountUser() {
        User user = new User("babor", "babu@gmal.com", "secret", true, "ROLE_ADMIN");
        usersDao.createUser(user);

        assertEquals("User count", 1, usersDao.getAll().size());
    }

    @Test
    public void testDummy() {
        assertEquals("Dummy test", 1, 1);
    }
}
