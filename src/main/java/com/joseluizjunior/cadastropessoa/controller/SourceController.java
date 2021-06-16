package com.joseluizjunior.cadastropessoa.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/source")
public class SourceController {

    @GetMapping
    public ResponseEntity<List<String>> getSource() {
        List<String> urls = new ArrayList<>(Arrays.asList("https://gitlab.com/estudos-junior/api-cadastro-pessoa.git", "https://gitlab.com/estudos-junior/front-cadastro-pessoas.git"));
        return ResponseEntity.ok(urls);
    }
}
