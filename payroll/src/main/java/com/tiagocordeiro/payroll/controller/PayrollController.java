package com.tiagocordeiro.payroll.controller;

import com.tiagocordeiro.payroll.domain.Employee;
import com.tiagocordeiro.payroll.domain.Payroll;
import com.tiagocordeiro.payroll.feignClients.EmployeeFeign;
import com.tiagocordeiro.payroll.services.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/payments")
public class PayrollController {

    @Autowired
    private PayrollService service;

    @GetMapping("{workerId}")
    public ResponseEntity<Payroll> getPayment(@PathVariable Long workerId, @RequestBody Payroll payroll) {
        return ResponseEntity.ok().body(service.getPayment(workerId, payroll));
    }
}
