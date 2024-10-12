package com.luciano.springboot.ms.clients.app.services;

import com.luciano.springboot.ms.clients.app.models.ClientDto;
import reactor.core.publisher.Mono;

public interface IClientService {
    Mono<ClientDto> getClientById(String id);
}
