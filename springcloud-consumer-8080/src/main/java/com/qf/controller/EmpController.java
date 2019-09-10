package com.qf.controller;

import com.qf.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping
    public Object getAll() {
        List<Employee> list = restTemplate.getForObject("http://springcloud-provider/employee", List.class);
        return list;
    }

}
