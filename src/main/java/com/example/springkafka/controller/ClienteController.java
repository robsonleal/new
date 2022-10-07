package com.example.springkafka.controller;

import com.example.springkafka.dto.ClienteDto;
import com.example.springkafka.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @PostMapping
    public ResponseEntity<ClienteDto> cadastrar(@RequestBody ClienteDto dto) {
        ClienteDto novoDto = service.cadastrar(dto);

        URI uri = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{codCliente}")
                    .buildAndExpand(novoDto.getCodigo())
                    .toUri();

        return ResponseEntity.created(uri).body(novoDto);
    }

    @GetMapping
    public ResponseEntity<List<ClienteDto>> listarTodos() {
        List<ClienteDto> list = service.listarTodos();

        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{codigo}")
    public ResponseEntity<ClienteDto> buscarPeloId(@PathVariable(name = "codigo") Long codigo) {
        ClienteDto dto = service.buscarPeloId(codigo);

        return ResponseEntity.ok(dto);
    }
}
