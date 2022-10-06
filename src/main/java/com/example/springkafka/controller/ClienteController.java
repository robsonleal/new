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
    public ResponseEntity<ClienteDto> cadastrarCliente(@RequestBody ClienteDto clienteDto) {
        ClienteDto novoCliente = service.cadastrarCliente(clienteDto);

        URI uri = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{codCliente}")
                    .buildAndExpand(novoCliente.getCodigoCliente())
                    .toUri();

        return ResponseEntity.created(uri).body(novoCliente);
    }

    @GetMapping
    public ResponseEntity<List<ClienteDto>> listarTodosOsClientes() {
        List<ClienteDto> clientes = service.listarTodosClientes();

        return ResponseEntity.ok(clientes);
    }

    @GetMapping(value = "/{codCliente}")
    public ResponseEntity<ClienteDto> buscarClientePeloCodigo(@PathVariable(name = "codCliente") Long codCliente) {
        ClienteDto cliente = service.buscarClientePeloCodigo(codCliente);

        return ResponseEntity.ok(cliente);
    }
}
