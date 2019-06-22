package com.wk.oa.controller;


import com.wk.oa.entity.Department;
import com.wk.oa.entity.Employee;
import com.wk.oa.global.Contant;
import com.wk.oa.service.DepartmentService;
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

    @Resource
    private DepartmentService departmentService;

    @RequestMapping("/list")
    public String list(Map<String, Object> map) {
        map.put("list",employeeService.getAll());
        return "employee_list";
    }

    @RequestMapping("/to_add")
    public String toadd(Map<String, Object> map) {
        map.put("employee", new Employee());
        map.put("dlist", departmentService.getAll());
        map.put("plist", Contant.getPosts());
        return "employee_add";
    }

    @RequestMapping("/add")
    public String add(Employee employee) {
        employeeService.add(employee);
        return ("redirect:list");
    }

    @RequestMapping(value = "/to_update", params = "sn")
    public String toUpdate(String sn, Map<String, Object> map) {
        map.put("employee", employeeService.get(sn));
        map.put("dlist", departmentService.getAll());
        map.put("plist", Contant.getPosts());
        return "employee_update";
    }

    @RequestMapping("/update")

    public String update(Employee employee){
        employeeService.edit(employee);
        return "redirect:list";
    }

    @RequestMapping(value="/remove",params = "sn")
    public String remove(String sn){
        employeeService.remove(sn);

        return  "redirect:list";
    }


}
