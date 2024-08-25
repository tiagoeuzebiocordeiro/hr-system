package com.tiagocordeiro.payroll.controller.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @AllArgsConstructor
public class ErrorMessage {

    private LocalDateTime timestamp;
    private String error;
    private Integer status;
    private String path;
}
