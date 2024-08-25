package com.tiagocordeiro.employee.services;

import com.tiagocordeiro.employee.domain.Employee;

import java.util.List;

public interface EmployeeService {

    Employee findById(Long id);
    List<Employee> findAll();

}
