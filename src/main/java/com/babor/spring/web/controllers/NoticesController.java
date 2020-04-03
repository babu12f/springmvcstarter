package com.babor.spring.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;

@Controller
public class NoticesController {

    @RequestMapping("/")
    public String showHome(HttpSession session) {
        session.setAttribute("name", "Shofiullah Babor");
        return "home";
    }

}
