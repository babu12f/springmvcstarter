package com.babor.spring.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class NoticesController {

    @RequestMapping("/")
    public ModelAndView showHome() {
        ModelAndView mv = new ModelAndView("home");

        Map<String, Object> model = mv.getModel();
        model.put("name", "jhon doe");

        return mv;
    }

}
