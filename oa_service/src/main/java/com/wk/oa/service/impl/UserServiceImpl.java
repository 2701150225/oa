package com.wk.oa.service.impl;

import com.wk.oa.dao.EmployeeDao;
import com.wk.oa.entity.Employee;
import com.wk.oa.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private EmployeeDao employeeDao;
    public Employee login(String sn, String password) {
        Employee employee=employeeDao.select(sn);
        if(employee!=null&&employee.getPassword().equals(password)){
            return employee;
        }
        return null;
    }

    public void changePassword(Employee employee) {
       employeeDao.update(employee);
    }
}
