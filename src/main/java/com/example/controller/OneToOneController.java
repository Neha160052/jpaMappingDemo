package com.example.controller;

import com.example.Department;
import com.example.Repository.EmployeeRepository;
import com.example.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping(value = "/o2m")
public class OneToOneController {

    @Autowired
    private EmployeeRepository employeeRepository;


    @RequestMapping(value = "/save")
    public String save(){
        Employee employee = new Employee("Neha","Engg");
        Set<Department> departments = new HashSet<>();
        departments.add(Department.ENGLISH);
        departments.add(Department.HINDI);
        employee.setDepartments(departments);
        employee = employeeRepository.save(employee);
        return employee.toString();
    }

    @RequestMapping(value = "/get")
    public String getEmployee(){
        return employeeRepository.getOne(1L).toString();
    }

}
