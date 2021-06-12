package com.joseluizjunior.cadastropessoa.dto;

import com.joseluizjunior.cadastropessoa.model.Municipio;
import com.joseluizjunior.cadastropessoa.model.UF;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class MunicipioDto {
    private Long id;
    private String nome;
    private UF uf;

    public MunicipioDto(Municipio municipio) {
        if (Objects.isNull(municipio)) {
            return;
        }
        this.id = municipio.getId();
        this.nome = municipio.getNome();
        this.uf = municipio.getUf();
    }

    public static Municipio dtoToEntity(MunicipioDto dto) {
        if (Objects.isNull(dto)) {
            return null;
        }
        return Municipio.builder()
                .id(dto.getId())
                .nome(dto.getNome())
                .uf(dto.getUf())
                .build();
    }

    public static Collection<MunicipioDto> entityToDto(Collection<Municipio> municipios) {
        return municipios.stream().map(MunicipioDto::new).collect(Collectors.toList());
    }
}
