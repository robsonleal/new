package com.example.springkafka.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter @Setter @ToString @EqualsAndHashCode
@AllArgsConstructor @NoArgsConstructor
@Document(collection = "cliente")
public class Cliente {
    @Id
    private Long codigo;
    private String nome;
}
