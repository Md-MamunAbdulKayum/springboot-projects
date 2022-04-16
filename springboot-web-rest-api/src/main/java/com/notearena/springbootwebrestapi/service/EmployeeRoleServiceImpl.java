package com.notearena.springbootwebrestapi.service;
/*
 * ------------------------------------------------------|
 * Kothok OrderProcessing System (KOS)
 * =====================================
 * 2022 NoteArena.com opensource project
 * @Author: Mamun Kayum
 * @Modified:
 * @Version: 1.0
 * Feel free use this implementation
 *-------------------------------------------------------|
 */

import com.notearena.springbootwebrestapi.model.EmployeeRole;
import com.notearena.springbootwebrestapi.repository.EmployeeRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeRoleServiceImpl implements EmployeeRoleService{

    @Autowired
    private EmployeeRoleRepository employeeRoleRepository;

    @Override
    public void addEmployeeRole (EmployeeRole employeeRole) {
        employeeRoleRepository.save(employeeRole);
    }

    @Override
    public Iterable<EmployeeRole> findAll() {
        return employeeRoleRepository.findAll();
    }
}

