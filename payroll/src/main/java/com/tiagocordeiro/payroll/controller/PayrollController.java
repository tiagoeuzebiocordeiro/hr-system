package com.tiagocordeiro.payroll.controller;

import com.tiagocordeiro.payroll.domain.Employee;
import com.tiagocordeiro.payroll.domain.Payroll;
import com.tiagocordeiro.payroll.feignClients.EmployeeFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/payments")
public class PayrollController {

    @Autowired
    private EmployeeFeign employeeFeign;

    @GetMapping("{workerId}")
    public ResponseEntity<Payroll> getPayment(@PathVariable Long workerId, @RequestBody Payroll payroll) {

        Employee employee = employeeFeign.findById(workerId).getBody();
        payroll.setHourlyPrice(employee.getHourlyPrice());
        payroll.setContractType(employee.getContractType().name());
        return ResponseEntity.ok().body(new Payroll(
                employee.getName(),
                payroll.getDescription(),
                employee.getHourlyPrice(),
                payroll.getWorkedHours(),
                payroll.getTotalPayment(),
                employee.getContractType().name()
        ));
    }
}
