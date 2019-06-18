package com.wk.oa.service;


import com.wk.oa.entiy.Department;

import java.util.List;

public interface DepartmentService {
    void add(Department department);
    void edit(Department department);
    void remove(String sn);
    Department get(String sn);
    List<Department> getAll();
}
