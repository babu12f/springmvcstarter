package com.babor.spring.web.services;

import com.babor.spring.web.dao.User;
import com.babor.spring.web.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
