package com.luciano.springboot.ms.clients.app.services;


import com.luciano.springboot.ms.clients.app.exceptions.ClientNotFoundException;
import com.luciano.springboot.ms.clients.app.models.ClientDto;
import com.luciano.springboot.ms.clients.app.repositories.ClientRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ClientService implements IClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Mono<ClientDto> getClientById(String id) {
        return clientRepository.findById(id)
                .flatMap(client -> {
                    return Mono.just(new ClientDto(client.getId(), client.getName(), client.getEmail()));
                })
                .switchIfEmpty(Mono.error(new ClientNotFoundException("Cliente no encontrado: "+id)));
    }
}

