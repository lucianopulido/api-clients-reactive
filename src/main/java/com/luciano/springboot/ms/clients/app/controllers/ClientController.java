package com.luciano.springboot.ms.clients.app.controllers;

import com.luciano.springboot.ms.clients.app.models.ClientDto;
import com.luciano.springboot.ms.clients.app.services.IClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    private final IClientService clientService;

    public ClientController(IClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<ClientDto>> getClientsByIds(@PathVariable String id) {
        return clientService.getClientById(id).map(ResponseEntity::ok).defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
