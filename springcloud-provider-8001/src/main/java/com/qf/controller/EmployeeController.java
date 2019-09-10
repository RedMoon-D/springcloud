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
        employee.setEmpno(2345);
        employee.setEname("Smith");
        employee.setJob("Clerk");

        return Arrays.asList(employee);
    }

}
