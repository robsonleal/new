package com.example.springkafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfiguration {
    @Value("${spring.kafka.pedido-topico.name}")
    private String pedidoTopico;

    @Bean
    NewTopic criaPedidoTopic(){
        return TopicBuilder
            .name(pedidoTopico)
            .build();
    }
}
