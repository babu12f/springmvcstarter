package com.babor.spring.web.controllers;

import com.babor.spring.web.dao.FormValidationGroup;
import com.babor.spring.web.dao.Notice;
import com.babor.spring.web.services.NoticesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
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

//    @ExceptionHandler(DataAccessException.class)
//    public String handleDataAccessException(DataAccessException ex) {
//        return "error";
//    }

    @RequestMapping("/notices")
    public String showNotice(Model model) {

//        noticesService.throwTestException();

        List<Notice> notices = noticesService.getCurrent();

        model.addAttribute("notices", notices);

        return "notices";
    }

    @RequestMapping("/createnotice")
    public String createNotice(Model model) {
        model.addAttribute("notice",new Notice());

        return "createnotice";
    }

    @RequestMapping(value = "/docreate", method = RequestMethod.POST)
    public String doCreate(Model model, @Validated(value = FormValidationGroup.class) Notice notice, BindingResult result, Principal logedInUser,
                           @RequestParam(value = "delete", required = false) String delete) {

        if( result.hasErrors() ) {
            return "createnotice";
        }

        if (delete == null) {
            // User want to create or update
            notice.getUser().setUsername(logedInUser.getName());

            noticesService.createOrUpdateNotice(notice, logedInUser);
        }
        else {
            // User want to delete notice
            noticesService.deleteNotice(notice, logedInUser);

            return "redirect:/";
        }

        return "noticecreated";
    }

    @RequestMapping("/editnotice/{id}")
    public String editNotice(@PathVariable("id") int id, Model model) {

        model.addAttribute("notice", noticesService.getNoticeById(id));

        return "createnotice";
    }
}
