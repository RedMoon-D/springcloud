package com.qf.fallbakService;

import com.qf.pojo.Employee;
import com.qf.service.EmpService;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class EmpServiceFallback implements EmpService {
    @Override
    public List<Employee> getAll() {
        System.out.println("服务降级=============");
        Employee employee = new Employee();

        return Arrays.asList(employee);
    }
}
