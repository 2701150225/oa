package com.wk.oa.service;

import com.wk.oa.entity.Employee;

public interface UserService {
    Employee login(String sn, String password);
    void changePassword(Employee employee);

}
