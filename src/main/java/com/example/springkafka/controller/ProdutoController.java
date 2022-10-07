package com.example.springkafka.controller;

import com.example.springkafka.dto.ProdutoDto;
import com.example.springkafka.service.ProdutoService;
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
@RequestMapping(path = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @PostMapping
    public ResponseEntity<ProdutoDto> cadastrar(@RequestBody ProdutoDto dto) {
        ProdutoDto novoDto = service.cadastrar(dto);

        URI uri = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{codigo}")
                    .buildAndExpand(novoDto.getCodigo())
                    .toUri();

        return ResponseEntity.created(uri).body(novoDto);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoDto>> listarTodos() {
        List<ProdutoDto> dtos = service.listarTodos();

        return ResponseEntity.ok(dtos);
    }

    @GetMapping(value = "/{codigo}")
    public ResponseEntity<ProdutoDto> buscarPeloCodigo(@PathVariable(name = "codigo") Long codigo) {
        ProdutoDto dtoEncontrado = service.buscarPeloCodigo(codigo);

        return ResponseEntity.ok(dtoEncontrado);
    }
}
