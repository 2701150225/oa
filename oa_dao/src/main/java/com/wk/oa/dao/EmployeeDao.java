package com.wk.oa.dao;

import com.wk.oa.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("employeeDao")
public interface EmployeeDao {
     void insert(Employee employee);
     void update(Employee employee);
     void delete(String sn);
     Employee select(String sn);
     List<Employee> selectAll();
}
