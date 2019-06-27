package com.wk.oa.service;

import com.wk.oa.entity.Employee;

import java.util.List;

public interface EmployeeService {
    void add(Employee employee);
    void edit(Employee employee);
    void remove(String sn);
    Employee get(String sn);
    List<Employee> getAll();

}
