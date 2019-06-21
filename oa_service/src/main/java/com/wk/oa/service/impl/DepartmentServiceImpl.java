package com.wk.oa.service.impl;

import com.wk.oa.dao.DepartmentDao;
import com.wk.oa.entity.Department;
import com.wk.oa.service.DepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

   @Resource
    private DepartmentDao departmentDao;

    public void add(Department department) {

        departmentDao.insert(department);
    }

    public void edit(Department department) {

        departmentDao.update(department);
    }

    public void remove(String sn) {

        departmentDao.delete(sn);
    }

    public Department get(String sn) {

        return departmentDao.select(sn);
    }

    public List<Department> getAll() {

        return departmentDao.selectAll();
    }
}
