package com.example.springkafka.kafka;

import com.example.springkafka.dto.PedidoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class PedidoProducer {
    @Value("${spring.kafka.pedido-topico.name}")
    private String topico;

    @Autowired
    private KafkaTemplate<String, PedidoDto> kafkaTemplate;

    public void enviarPedido(PedidoDto dto){
        Message<PedidoDto> msg = MessageBuilder
                                    .withPayload(dto)
                                    .setHeader(KafkaHeaders.TOPIC, topico)
                                    .build();

        kafkaTemplate.send(msg);
    }
}
