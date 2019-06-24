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

    @RequestMapping("/quit")
    public String quit(HttpSession session){
        session.setAttribute("employee",null);
        return "redirect:to_login";
    }

    @RequestMapping("/to_change_password")
        public String toChangePassword(){
        return  "change_password";
        }

    @RequestMapping("/change_password")
    public String changePassword(HttpSession session, @RequestParam String oldPassword,@RequestParam String newPassword1,@RequestParam String newPassword2) {
        Employee employee = (Employee) session.getAttribute("employee");
        if (employee.getPassword().equals(oldPassword)) {
            if (newPassword1.equals(newPassword2)) {
                employee.setPassword(newPassword1);
                userService.changePassword(employee);
                return "redirect:to_login";
            }
        }
        return "redirect:to_change_password";
    }
}
