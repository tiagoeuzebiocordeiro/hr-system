package com.tiagocordeiro.employee;

import com.tiagocordeiro.employee.domain.Employee;
import com.tiagocordeiro.employee.enums.ContractType;
import com.tiagocordeiro.employee.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class EmployeeApplication implements CommandLineRunner {

	@Autowired
	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		employeeRepository.saveAll(List.of(
//				new Employee(null, "John Doe", 80.0, ContractType.STANDARD),
//				new Employee(null, "Maria Green", 120.0, ContractType.SPECIAL),
//				new Employee(null, "Bob Brown", 50.0, ContractType.TEMPORARY)
//		));
	}
}
