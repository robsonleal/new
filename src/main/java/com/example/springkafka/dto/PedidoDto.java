package com.example.springkafka.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter @Setter @ToString @EqualsAndHashCode
@AllArgsConstructor @NoArgsConstructor
public class PedidoDto {
    private Long codCliente;
    private List<Long> itens;
}
