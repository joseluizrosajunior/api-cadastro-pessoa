package com.joseluizjunior.cadastropessoa.model;

import com.querydsl.core.annotations.QueryEntity;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.io.Serializable;
import java.time.LocalDate;

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

    @Column(length = 11)
    private String cpf;

}
