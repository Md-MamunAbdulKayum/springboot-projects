package com.notearena.springbootwebrestapi.model;

import javax.persistence.*;

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
@Entity
@Table(name = "employee_role")
public class EmployeeRole {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "emp_id")
    private Integer empRoleId;

    @Column(name = "emp_role_title")
    private String empRoleTitle;

    public Integer getEmpRoleId() {
        return empRoleId;
    }

    public void setEmpRoleId(Integer empRoleId) {
        this.empRoleId = empRoleId;
    }

    public String getEmpRoleTitle() {
        return empRoleTitle;
    }

    public void setEmpRoleTitle(String empRoleTitle) {
        this.empRoleTitle = empRoleTitle;
    }
}
