package com.tiagocordeiro.payroll.domain;

import com.tiagocordeiro.payroll.enums.ContractType;
import lombok.*;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Employee {
    private Long id;
    private String name;
    private Double hourlyPrice;
    private  ContractType contractType;
}
