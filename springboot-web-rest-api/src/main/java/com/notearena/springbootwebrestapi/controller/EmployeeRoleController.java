package com.notearena.springbootwebrestapi.controller;


import com.notearena.springbootwebrestapi.model.EmployeeRole;
import com.notearena.springbootwebrestapi.service.EmployeeRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/api/v1/employee_role")
public class EmployeeRoleController {

    @Autowired
    private EmployeeRoleService employeeRoleService;

    private EmployeeRole employeeRole;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewUser (@RequestParam String empRoleTitle) {

        employeeRole = new EmployeeRole();
        employeeRole.setEmpRoleTitle(empRoleTitle);
        employeeRoleService.addEmployeeRole(employeeRole);
        return "Saved employee role";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<EmployeeRole> getAllUsers() {
        return employeeRoleService.findAll();
    }
}
