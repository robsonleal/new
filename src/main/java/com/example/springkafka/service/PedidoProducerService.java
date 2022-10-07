package com.example.springkafka.service;

import com.example.springkafka.dto.PedidoDto;
import com.example.springkafka.kafka.PedidoProducer;
import com.example.springkafka.repository.ClienteRepository;
import com.example.springkafka.repository.ProdutoRepository;
import com.example.springkafka.service.exception.IllegalArgumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoProducerService {
    @Autowired
    private PedidoProducer pedidoProducer;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ProdutoRepository produtoRepository;

    public void enviarPedido(PedidoDto dto){
        if (dto == null)
            throw new IllegalArgumentException("Pedido inválido!");

        clienteRepository
            .findById(dto.getCodCliente())
            .orElseThrow(() -> new IllegalArgumentException("Cliente inválido no pedido!"));

        for(Long item: dto.getItens()){
            produtoRepository
                .findById(item)
                .orElseThrow(() -> new IllegalArgumentException("Item inválido!"));
        }

        pedidoProducer.enviarPedido(dto);
    }

}
