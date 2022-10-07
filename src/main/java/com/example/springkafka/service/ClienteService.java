package com.example.springkafka.service;

import com.example.springkafka.dto.ClienteDto;
import com.example.springkafka.model.Cliente;
import com.example.springkafka.repository.ClienteRepository;
import com.example.springkafka.service.exception.IllegalArgumentException;
import com.example.springkafka.service.exception.ResourceNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public ClienteDto cadastrar(ClienteDto dto) {
        repository.findById(dto.getCodigo())
            .ifPresent( x -> {
                throw new IllegalArgumentException("Cliente com id '" + dto.getCodigo() + "' já cadastrado!");
            });

        Cliente entity = new Cliente();
        BeanUtils.copyProperties(dto, entity);

        return new ClienteDto(repository.insert(entity));
    }

    public List<ClienteDto> listarTodos() {
        List<Cliente> list = repository.findAll();

        return list.stream().map(ClienteDto::new).collect(Collectors.toList());
    }

    public ClienteDto buscarPeloId(Long codigo) {
        return new ClienteDto(repository.findById(codigo).orElseThrow(
            () -> new ResourceNotFoundException("Cliente com id '" + codigo + "' não encontrado!")
        ));
    }
}
