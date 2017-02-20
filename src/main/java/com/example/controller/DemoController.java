package com.example.controller;

import com.example.Repository.DepartmentRepository;
import com.example.Repository.EmployeeRepository;
import com.example.entity.Department;
import com.example.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping(value = "/o2m")
public class DemoController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @RequestMapping(value = "/save")
    public String save(){
        Department department  = new Department("Technical");
        department = departmentRepository.saveAndFlush(department);
        Employee employee = new Employee("Neha","Engg",department);
        employee = employeeRepository.save(employee);
        return employee.toString();
    }

    @RequestMapping(value = "/save2")
    public String save2Employee(){
        Department department  = new Department("Technical");
        Employee employee = new Employee("Neha","Engg",department);
        Employee employee2 = new Employee("Neha","Engg",department);
        employee = employeeRepository.saveAndFlush(employee);
        employee2 = employeeRepository.saveAndFlush(employee2);
        Collection<Employee> employees = new ArrayList<>();

        employees.add(employee);
        employees.add(employee2);
        department.setEmployees(employees);
        department = departmentRepository.saveAndFlush(department);
        return department.toString();
    }

    @RequestMapping(value = "/delete/{id}" , method = RequestMethod.GET)
    public String delete(@PathVariable long id){
        System.out.println("Delete Employee");
        Employee employee = employeeRepository.getOne(id);

        employeeRepository.delete(employee);
        return "Employee for ID : " + employee;
    }

    @RequestMapping(value = "/delete/department/{id}")
    public String deleteDepartment(@PathVariable long id){
        Department department = departmentRepository.getOne(id);
        departmentRepository.delete(department);
        return department.toString();
    }
}
