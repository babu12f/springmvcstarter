package com.babor.spring.web.controllers;

import com.babor.spring.web.dao.User;
import com.babor.spring.web.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class LoginController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/login")
    public String showHome() {
        return "login";
    }

    @RequestMapping("/createaccount")
    public String showCreateAccount(Model model) {
        model.addAttribute("user", new User());
        return "createaccount";
    }

    @RequestMapping("/admin")
    public String showAdmin(Model model) {
        List<User> users = userService.getAllUser();

        model.addAttribute("users", users);

        return "admin";
    }

    @RequestMapping( value = "/createaccount", method = RequestMethod.POST)
    public String doCreateAccount(@Valid User user, BindingResult result) {

        if( result.hasErrors() ) {
            return "createaccount";
        }

        user.setAuthority("user");
        user.setEnabled(true);

        /**
         * second Approach
         * */
        if (userService.exists(user.getUsername())) {
            result.rejectValue("username", "DuplicateKey.user.username");
            return "createaccount";
        }

        /**
         * Check Duplicate Username --> First Approach (Using try catch) NOTE: not relaiable
         * */
        try {
            userService.createUser(user);
        } catch (DuplicateKeyException ex) {
            result.rejectValue("username", "DuplicateKey.user.username");
            return "createaccount";
        }

        return "accountcreated";
    }
}
