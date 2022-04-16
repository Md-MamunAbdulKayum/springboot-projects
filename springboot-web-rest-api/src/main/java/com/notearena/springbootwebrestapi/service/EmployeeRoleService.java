package com.notearena.springbootwebrestapi.service;

import com.notearena.springbootwebrestapi.model.EmployeeRole;

import java.util.List;

public interface EmployeeRoleService {
    public void addEmployeeRole (EmployeeRole employeeRole);
    public Iterable<EmployeeRole> findAll();
}
