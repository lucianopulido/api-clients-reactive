package com.luciano.springboot.ms.clients.app.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collection = "clients")
public class Client {
    @Id
    private String id;
    private String name;
    private String email;
}
