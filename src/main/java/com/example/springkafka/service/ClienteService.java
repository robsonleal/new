package com.example.springkafka.service;

import com.example.springkafka.dto.ClienteDto;
import com.example.springkafka.model.Cliente;
import com.example.springkafka.repository.ClienteRepository;
import com.example.springkafka.service.exception.IllegalArgumentException;
import com.example.springkafka.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public ClienteDto cadastrarCliente(ClienteDto clienteDto) {
        Cliente cliente = repository.findByCodigoCliente(clienteDto.getCodigoCliente());

        if (cliente != null)
            throw new IllegalArgumentException("Cliente já existe!");

        cliente = new Cliente(clienteDto.getCodigoCliente(), clienteDto.getNomeCliente());

        return new ClienteDto(repository.insert(cliente));
    }

    public List<ClienteDto> listarTodosClientes() {
        List<Cliente> clientes = repository.findAll();

        return clientes.stream().map(ClienteDto::new).collect(Collectors.toList());
    }

    public ClienteDto buscarClientePeloCodigo(Long codigo) {
        Cliente cliente = repository.findByCodigoCliente(codigo);

        if (cliente == null)
            throw new ResourceNotFoundException("Cliente não encontrado!");

        return new ClienteDto(cliente);
    }
}
