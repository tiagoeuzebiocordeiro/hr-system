package com.tiagocordeiro.employee.repositories;

import com.tiagocordeiro.employee.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
