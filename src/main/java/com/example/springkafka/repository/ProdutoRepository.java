package com.example.springkafka.repository;

import com.example.springkafka.model.Produto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProdutoRepository extends MongoRepository<Produto, Long> {
}
