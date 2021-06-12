package com.joseluizjunior.cadastropessoa.controller;

import com.joseluizjunior.cadastropessoa.dto.MunicipioDto;
import com.joseluizjunior.cadastropessoa.model.QMunicipio;
import com.joseluizjunior.cadastropessoa.model.UF;
import com.joseluizjunior.cadastropessoa.service.MunicipioService;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/municipios")
public class MunicipioController {

    @Autowired
    private MunicipioService municipioService;

    @GetMapping
    public ResponseEntity<List<MunicipioDto>> getAll(@RequestParam(required = false) UF uf, @RequestParam(required = false, defaultValue = "") String nome) {
        BooleanExpression where = QMunicipio.municipio.nome.toLowerCase().like(nome.toLowerCase() + "%");
        if (!Objects.isNull(uf)) {
            where = where.and(QMunicipio.municipio.uf.eq(uf));
        }
        List<MunicipioDto> municipios = municipioService.findAll(where)
                .stream()
                .map(MunicipioDto::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(municipios);
    }
}
