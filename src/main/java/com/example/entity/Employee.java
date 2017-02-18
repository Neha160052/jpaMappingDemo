package com.example.entity;

import com.example.Department;
import org.hibernate.annotations.Fetch;
import org.hibernate.mapping.Collection;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "deg")
    private String deg;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "department")
    @Column(name = "department_name")
    @Enumerated(EnumType.STRING)
    private Set<Department> departments;

    public Employee() {
    }

    public Employee(String name, String deg) {
        this.name = name;
        this.deg = deg;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeg() {
        return deg;
    }

    public void setDeg(String deg) {
        this.deg = deg;
    }

    public Set<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", deg='" + deg + '\'' +
                ", departments=" + departments +
                '}';
    }
}
