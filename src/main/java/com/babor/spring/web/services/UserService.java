package com.babor.spring.web.services;

import com.babor.spring.web.dao.User;
import com.babor.spring.web.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserService {
    private UserDAO userDAO;

    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void createUser(User user) {
        userDAO.createUser(user);
    }

    public boolean exists(String username) {
        return userDAO.exists(username);
    }

    @Secured("ROLE_ADMIN")
    public List<User> getAllUser() {
        return userDAO.getAll();
    }
}
