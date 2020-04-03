package com.babor.spring.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NoticesController {

    @RequestMapping("/")
    public String showHome(Model model) {
        model.addAttribute("name", "<b>jhon doe</b>");

        return "home";
    }

}
