package com.babor.spring.web.controllers;

import com.babor.spring.web.dao.Notice;
import com.babor.spring.web.services.NoticesService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    private static Logger logger = Logger.getLogger(HomeController.class);

    @Autowired
    NoticesService noticesService;

    @RequestMapping("/")
    public String showHome(Model model, Principal principal) {
        List<Notice> notices = new ArrayList<>();

        if (principal != null) {
            notices = noticesService.getCurrentUserNotices(principal.getName());
        }

        model.addAttribute("notices", notices);

        return "home";
    }
}
