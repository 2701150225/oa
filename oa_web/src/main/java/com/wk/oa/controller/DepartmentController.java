package com.wk.oa.controller;

import com.wk.oa.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Map;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;
    @RequestMapping("/list")
    public  String  list(Map<String ,Object> map){
    map.put("list",departmentService.getAll());
    return "department_list";
    }


}
