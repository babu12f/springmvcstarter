package com.babor.spring.web.controllers;

import com.babor.spring.web.dao.Notice;
import com.babor.spring.web.services.NoticesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
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

    @RequestMapping(value = "/docreate", method = RequestMethod.POST)
    public String doCreate(Model model, @Valid Notice notice, BindingResult result) {
        System.out.println(notice);
        if( result.hasErrors() ) {
            List<ObjectError> errors = result.getAllErrors();

            for(ObjectError error: errors) {
                System.out.println(error.getDefaultMessage());
            }
        } else {
            System.out.println("Form validated");
        }

        return "noticecreated";
    }
}
