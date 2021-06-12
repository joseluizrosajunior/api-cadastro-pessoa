package com.joseluizjunior.cadastropessoa.dto;

import com.joseluizjunior.cadastropessoa.model.Pais;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class PaisDto {
    private Long id;
    private String nome;

    public PaisDto(Pais pais) {
        if (Objects.isNull(pais)) {
            return;
        }
        this.id = pais.getId();
        this.nome = pais.getNome();
    }


    public static Pais dtoToEntity(PaisDto dto) {
        if (Objects.isNull(dto)) {
            return null;
        }
        return Pais.builder()
                .id(dto.getId())
                .nome(dto.getNome())
                .build();
    }

    public static Collection<PaisDto> entityToDto(Collection<Pais> paises) {
        return paises.stream().map(PaisDto::new).collect(Collectors.toList());
    }
}
