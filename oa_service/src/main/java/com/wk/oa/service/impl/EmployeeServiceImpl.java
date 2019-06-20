package com.wk.oa.service.impl;


import com.wk.oa.dao.EmployeeDao;
import com.wk.oa.entity.Employee;
import com.wk.oa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public void add(Employee employee) {
        employee.setPassword("123456");
       employeeDao.insert(employee);
    }

    public void edit(Employee employee) {

       employeeDao.update(employee);
    }

    public void remove(String sn) {

       employeeDao.delete(sn);
    }

    public Employee get(String sn) {

        return employeeDao.select(sn);
    }

    public List<Employee> getAll() {

        return employeeDao.selectAll();
    }
}
