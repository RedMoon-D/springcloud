package com.qf.controller;

import com.qf.service.EmpService;
import com.qf.pojo.Employee;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmpController {

//    @Autowired
//    private RestTemplate restTemplate;

    @Resource
    private EmpService empService;

    @RequestMapping
    public Object getAll() {
        //List<Employee> list = restTemplate.getForObject("http://springcloud-provider/employee", List.class);
        List<Employee> list = empService.getAll();
        return list;
    }

}
