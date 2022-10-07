package com.example.springkafka.dto;

import com.example.springkafka.model.Produto;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @EqualsAndHashCode
@AllArgsConstructor @NoArgsConstructor
public class ProdutoDto {
    private Long codigo;
    private String nome;

    public ProdutoDto(Produto produto) {
        codigo = produto.getCodigo();
        nome = produto.getNome();
    }
}
