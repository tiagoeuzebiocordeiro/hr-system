package com.tiagocordeiro.payroll.domain;

import lombok.*;

@Getter @Setter @AllArgsConstructor
public class Payroll {

    private String workerName;
    private String description;
    private Double hourlyPrice;
    private Double workedHours;
    private Double totalPayment;
    private String contractType;

    public double getTotalPayment() {
        double grossPayment = this.hourlyPrice * workedHours;
        double taxRate = whichContract(this.contractType, this.workedHours);
        return this.totalPayment = grossPayment - (grossPayment * taxRate);
    }

    public static double whichContract(String contractType, double workedHours) {
        return switch (contractType.toUpperCase()) {
            case "SPECIAL" -> 0.2;
            case "TEMPORARY" -> (workedHours > 160) ? 0.15 : 0.05;
            default -> 0.1;
        };
    }
}
