package com.example.springkafka.service;

import com.example.springkafka.dto.ProdutoDto;
import com.example.springkafka.model.Produto;
import com.example.springkafka.repository.ProdutoRepository;
import com.example.springkafka.service.exception.IllegalArgumentException;
import com.example.springkafka.service.exception.ResourceNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public ProdutoDto cadastrar(ProdutoDto dto) {
        repository.findById(dto.getCodigo())
            .ifPresent(
                x -> { throw new IllegalArgumentException("Produto já existe!"); }
            );

        Produto entity = new Produto();
        BeanUtils.copyProperties(dto, entity);

        return new ProdutoDto(repository.insert(entity));
    }

    public List<ProdutoDto> listarTodos() {
        List<Produto> list = repository.findAll();

        return list.stream().map(ProdutoDto::new).collect(Collectors.toList());
    }

    public ProdutoDto buscarPeloCodigo(Long codigo) {
        return new ProdutoDto(repository.findById(codigo).orElseThrow(
            () -> new ResourceNotFoundException("Produto não encontrado!")
        ));
    }
}
