package com.sy.controller;

import com.sy.model.User;
import com.sy.service.UserService;
import io.netty.handler.codec.http.HttpRequest;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.*;

@Controller
@CrossOrigin
public class CasController {

    @Autowired
    private UserService service;
    @RequestMapping("/login")
    public String rollback(HttpServletRequest request, HttpSession session, HttpServletResponse response)throws Exception{

        User byUsername = service.findByUsername(request.getRemoteUser());
        session.setAttribute("sessionUser",byUsername);
        Cookie cookie = new Cookie("JSESSIONID",session.getId());
        response.addCookie(cookie);
        return "redirect:http://localhost:63342/syagent-html/index.html";
    }

    @RequestMapping("/logout")
    public String logout(){
        return "redirect:http://localhost:9999/cas/logout";
    }
}
