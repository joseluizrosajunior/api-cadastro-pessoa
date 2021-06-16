package com.joseluizjunior.cadastropessoa.model;

import com.querydsl.core.annotations.QueryEntity;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@QueryEntity
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200)
    private String nome;

    @Column(length = 150)
    private String email;

    private LocalDate dataNascimento;

    @ManyToOne
    private Municipio naturalidade;

    @ManyToOne
    private Pais nacionalidade;

    @Column(length = 11, unique = true)
    private String cpf;

    private LocalDateTime createdIn = LocalDateTime.now();

    private LocalDateTime updatedIn;

}
