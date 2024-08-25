package com.tiagocordeiro.payroll.feignClients;

import com.tiagocordeiro.payroll.domain.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "employee")
public interface EmployeeFeign {

    @GetMapping("/api/v1/employees/{id}")
    ResponseEntity<Employee> findById(@PathVariable Long id);
    @GetMapping
    ResponseEntity<List<Employee>> findAll();
}
