package com.example.springkafka.kafka;

import com.example.springkafka.dto.PedidoDto;
import com.example.springkafka.model.Pedido;
import com.example.springkafka.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PedidoConsumer {
    @Autowired
    private PedidoRepository repository;

    @KafkaListener(topics = "${spring.kafka.pedido-topico.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void ConsumerPedido(PedidoDto dto) {
        Pedido entity = new Pedido(dto.getCodCliente(), dto.getItens());

        repository.insert(entity);
    }
}
