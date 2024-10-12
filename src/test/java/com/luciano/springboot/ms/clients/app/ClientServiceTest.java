package com.luciano.springboot.ms.clients.app;

import com.luciano.springboot.ms.clients.app.exceptions.ClientNotFoundException;
import com.luciano.springboot.ms.clients.app.models.Client;
import com.luciano.springboot.ms.clients.app.repositories.ClientRepository;
import com.luciano.springboot.ms.clients.app.services.ClientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.when;

public class ClientServiceTest {

    private ClientService clientService;
    private ClientRepository clientRepository;

    @BeforeEach
    public void setUp() {
        clientRepository = Mockito.mock(ClientRepository.class);
        clientService = new ClientService(clientRepository);
    }

    @Test
    public void testGetClientByIdSuccess() {
        String clientId = "123";
        Client client = new Client(clientId, "Juan", "juan@example.com");
        when(clientRepository.findById(clientId)).thenReturn(Mono.just(client));

        StepVerifier.create(clientService.getClientById(clientId))
                .expectNextMatches(clientDto -> clientDto.getCustomerId().equals(clientId)
                        && clientDto.getCustomerName().equals("Juan")
                        && clientDto.getEmail().equals("juan@example.com"))
                .verifyComplete();
    }

    @Test
    public void testGetClientByIdNotFound() {
        String clientId = "123";
        when(clientRepository.findById(clientId)).thenReturn(Mono.empty());

        StepVerifier.create(clientService.getClientById(clientId))
                .expectError(ClientNotFoundException.class)
                .verify();
    }
}
