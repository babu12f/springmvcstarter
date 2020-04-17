package com.babor.spring.web.test.tests;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

@ActiveProfiles("dev")
@ContextConfiguration(locations = {
        "classpath:dao-context.xml",
        "classpath:security-context.xml",
        "classpath:datasource.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Ignore
public class BaseTests {

    @Autowired
    private DataSource dataSource;

    @Before
    public void init() {
        JdbcTemplate jdbc = new JdbcTemplate(dataSource);

        jdbc.execute("truncate notices");
        jdbc.execute("truncate authorities");
        jdbc.execute("truncate users");
    }
}
