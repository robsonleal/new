package com.example.springkafka.dto;

import com.example.springkafka.model.Cliente;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @EqualsAndHashCode
@AllArgsConstructor @NoArgsConstructor
public class ClienteDto {
    private Long codigo;
    private String nome;

    public ClienteDto(Cliente entity) {
        codigo = entity.getCodigo();
        nome = entity.getNome();
    }
}
