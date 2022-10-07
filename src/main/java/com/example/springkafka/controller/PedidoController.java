package com.example.springkafka.controller;

import com.example.springkafka.dto.PedidoDto;
import com.example.springkafka.service.PedidoProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/pedidos")
public class PedidoController {
    @Autowired
    private PedidoProducerService service;

    @PostMapping
    public ResponseEntity<String> cadastraPedido(@RequestBody PedidoDto dto){
        service.enviarPedido(dto);
        return ResponseEntity.ok("Pedido criado!");
    }
}
