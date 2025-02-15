package com.luciano.springboot.ms.clients.app.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDto {
    private String message;
    private String error;
    private int status;
    private LocalDateTime timestamp;
}
