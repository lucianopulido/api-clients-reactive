package com.luciano.springboot.ms.clients.app.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto {
    private String customerId;
    private String customerName;
    private String email;
}
