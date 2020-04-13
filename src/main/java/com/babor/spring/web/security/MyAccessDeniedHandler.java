package com.babor.spring.web.security;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component("myAccessDeniedHandler")
public class MyAccessDeniedHandler implements AccessDeniedHandler {

    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
        System.out.println("========================= Access denied ===========================");
        //some action
        //request.getRequestDispatcher("/login").forward(request, response);
        request.getRequestDispatcher(request.getRequestURI()).forward(request,response);
    }
}
