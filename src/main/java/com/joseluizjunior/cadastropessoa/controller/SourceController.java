package com.joseluizjunior.cadastropessoa.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/source")
public class SourceController {

    @GetMapping
    public ResponseEntity<String> getSource() {
        String urlSource = "https://gitlab.com/estudos-junior/api-cadastro-pessoa.git";
        return ResponseEntity.ok(urlSource);
    }
}
