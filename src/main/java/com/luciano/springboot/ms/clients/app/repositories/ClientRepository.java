package com.luciano.springboot.ms.clients.app.repositories;

import com.luciano.springboot.ms.clients.app.models.Client;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends ReactiveMongoRepository<Client, String> {
}