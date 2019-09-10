package com.qf.controller;

import com.qf.pojo.Employee;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @RequestMapping
    public Object getAll() {
        Employee employee = new Employee();
        employee.setEmpno(1234);
        employee.setEname("Bob");
        employee.setJob("Manager");

        Employee employee1 = new Employee();
        employee1.setEmpno(7890);
        employee1.setEname("Will");
        employee1.setJob("King");

        return Arrays.asList(employee, employee1);
    }
}
