package com.joseluizjunior.cadastropessoa.controller;

import com.joseluizjunior.cadastropessoa.dto.PaisDto;
import com.joseluizjunior.cadastropessoa.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/paises")
public class PaisController {

    @Autowired
    private PaisService paisService;

    @GetMapping
    public ResponseEntity<List<PaisDto>> getAll() {
        List<PaisDto> paises = paisService.findAll()
                .stream()
                .map(PaisDto::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(paises);
    }
}
