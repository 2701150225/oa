package com.wk.oa.controller;


import com.wk.oa.entity.Employee;
import com.wk.oa.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller("userController")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/to_login")
    public String toLogin(){
        return  "login";
    }

    @RequestMapping("/login")
    public String login(HttpSession session, @RequestParam String sn,@RequestParam String password){
        Employee employee =userService.login(sn,password);
        if (employee==null){
            return "redirect:login";
        }
        session.setAttribute("employee",employee);
        return "redirect:user";
    }

    @RequestMapping("/user")
    public String user(){
        return "user";
    }
}
