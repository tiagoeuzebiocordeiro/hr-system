package com.tiagocordeiro.employee.services.impl;

import com.tiagocordeiro.employee.domain.Employee;
import com.tiagocordeiro.employee.repositories.EmployeeRepository;
import com.tiagocordeiro.employee.services.EmployeeService;
import com.tiagocordeiro.employee.services.exceptions.ObjectNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;
    @Autowired
    private Environment env;
    @Override
    @Transactional(readOnly = true)
    public Employee findById(Long id) {
        log.info("EMPLOYEE_SERVICE ::: Get Request on {} port", env.getProperty("local.server.port"));
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(String.format(
                "Employee of id=%s not found", id
        )));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Employee> findAll() {
        return repository.findAll();
    }
}
