package com.example.springkafka.repository;

import com.example.springkafka.model.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClienteRepository extends MongoRepository<Cliente, Long> {
    Cliente findByCodigoCliente(Long codigo);
}
