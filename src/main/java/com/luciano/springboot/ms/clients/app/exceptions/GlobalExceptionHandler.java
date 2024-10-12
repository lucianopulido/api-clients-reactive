package com.luciano.springboot.ms.clients.app.exceptions;


import com.luciano.springboot.ms.clients.app.models.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ClientNotFoundException.class)
    public Mono<ResponseEntity<ErrorDto>> handleProductNotFound(ClientNotFoundException ex) {
        ErrorDto error = new ErrorDto(ex.getMessage(), "Cliente no encontrado",
                HttpStatus.NOT_FOUND.value(),
                LocalDateTime.now());
        return Mono.just(new ResponseEntity<>(error, HttpStatus.NOT_FOUND));
    }
}
