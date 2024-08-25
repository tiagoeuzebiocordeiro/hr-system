package com.tiagocordeiro.payroll.services;

import com.tiagocordeiro.payroll.domain.Payroll;
import com.tiagocordeiro.payroll.feignClients.EmployeeFeign;
import com.tiagocordeiro.payroll.services.exceptions.ObjectNotFoundException;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
public class PayrollService {

    @Autowired
    private Environment env;
    @Autowired
    private EmployeeFeign feign;

    public Payroll getPayment(Long workerId, Payroll payroll) {
        log.info("PAYROLL_SERVICE ::: Get Request on {} port", env.getProperty("local.server.port"));
        try {
            var employee = feign.findById(workerId).getBody();

            if (Objects.nonNull(employee)) {

                payroll.setHourlyPrice(employee.getHourlyPrice());
                payroll.setContractType(employee.getContractType().name());
                return new Payroll(
                        employee.getName(),
                        payroll.getDescription(),
                        employee.getHourlyPrice(),
                        payroll.getWorkedHours(),
                        payroll.getTotalPayment(),
                        employee.getContractType().name()
                );
            }
        } catch (FeignException.NotFound ex) {
            throw new ObjectNotFoundException(String.format("Error! Cannot generate a payroll for this Employee." +
                    " Reason: Employee of id=%s not found", workerId));
        }
        return null;

    }

}
