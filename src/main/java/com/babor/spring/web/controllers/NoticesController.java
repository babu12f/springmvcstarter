package com.babor.spring.web.controllers;

import com.babor.spring.web.dao.Notice;
import com.babor.spring.web.services.NoticesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class NoticesController {

    NoticesService noticesService;

    @Autowired
    public void setNoticesService(NoticesService noticesService) {
        this.noticesService = noticesService;
    }

    @RequestMapping("/test")
    public String showTest(@RequestParam("id") int id) {
        System.out.println("Id : " + id);
        return "home";
    }

    @RequestMapping("/notices")
    public String showNotice(Model model) {

        List<Notice> notices = noticesService.getCurrent();

        model.addAttribute("notices", notices);

        return "notices";
    }

    @RequestMapping("/createnotice")
    public String createNotice() {
        return "createnotice";
    }

    @RequestMapping("/docreate")
    public String doCreate() {
        return "noticecreated";
    }
}
