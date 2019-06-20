package com.wk.oa.controller;


import com.wk.oa.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Map;

@Controller("employeeController")
@RequestMapping("/employee")
public class EmployeeController {

    @Resource
    private EmployeeService employeeService;

    @RequestMapping("/list")
    public String list(Map<String, Object> map) {
        map.put("list", employeeService.getAll());
        return "employee_list";
    }


}
