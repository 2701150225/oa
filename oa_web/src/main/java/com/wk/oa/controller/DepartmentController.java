package com.wk.oa.controller;

import com.wk.oa.entity.Department;
import com.wk.oa.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.annotation.Resource;
import java.util.Map;

@Controller("departmentController")
@RequestMapping("/department")
public class DepartmentController {

    @Resource
    private DepartmentService departmentService;

    @RequestMapping("/list")
    public String list(Map<String, Object> map) {
        map.put("list", departmentService.getAll());
        return "department_list";
    }

    @RequestMapping("/to_add")
    public String toadd(Map<String, Object> map) {
        map.put("department", new Department());
        return "department_add";
    }

    @RequestMapping("/add")
    public String add(Department department) {
        departmentService.add(department);
        return ("redirect:list");
    }

    @RequestMapping(value = "/to_update", params = "sn")
    public String toUpdate(String sn, Map<String, Object> map) {
        map.put("department", departmentService.get(sn));
        return "department_update";
    }

    @RequestMapping("/update")
    public String update(Department department){
        departmentService.edit(department);
       return "redirect:list";
    }

    @RequestMapping(value="/remove",params = "sn")
    public String remove(String sn){
          departmentService.remove(sn);

        return  "redirect:list";
    }

    @RequestMapping("/refresh")
    public  String refresh(){
        return "redirect:list";
    }
}
