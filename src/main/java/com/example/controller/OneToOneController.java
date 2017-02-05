package com.example.controller;

import com.example.Repository.DepartmentRepository;
import com.example.Repository.EmployeeRepository;
import com.example.entity.Department;
import com.example.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OneToOneController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    static {
    }

   public Department department;

    @RequestMapping(name = "/save")
    public String save(){
        Department department  = new Department("Technical");
        department = departmentRepository.saveAndFlush(department);
        Employee employee = new Employee("Neha","Engg",department);
        Employee employee2 = new Employee("Neha","Engg",department);
        employee = employeeRepository.save(employee);
        employee2 = employeeRepository.save(employee2);
        return "Employee1 = " + employee.toString() + "   Employee2 = " + employee2.toString();
    }

}
