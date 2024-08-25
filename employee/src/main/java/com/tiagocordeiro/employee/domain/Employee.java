package com.tiagocordeiro.employee.domain;

import com.tiagocordeiro.employee.enums.ContractType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "tb_employee")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @NotBlank(message = "Employee's name cannot be blank")
    @Size(min = 3, max = 60, message = "Employee's name must be between 3 and 60 characters")
    private String name;
    @NotNull(message = "Employee's hourly price cannot be null")
    private Double hourlyPrice;
    @Enumerated(EnumType.STRING)
    private ContractType contractType;
}
