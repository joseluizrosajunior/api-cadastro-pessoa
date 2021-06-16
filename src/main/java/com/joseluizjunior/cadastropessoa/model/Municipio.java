package com.joseluizjunior.cadastropessoa.model;

import com.querydsl.core.annotations.QueryEntity;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@QueryEntity
public class Municipio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200)
    private String nome;

    @Column(length = 2)
    @Enumerated(EnumType.STRING)
    private UF uf;

    private LocalDateTime createdIn = LocalDateTime.now();

    private LocalDateTime updatedIn;
}
