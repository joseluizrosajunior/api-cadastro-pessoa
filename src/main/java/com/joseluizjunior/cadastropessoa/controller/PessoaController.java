package com.joseluizjunior.cadastropessoa.controller;

import com.joseluizjunior.cadastropessoa.dto.PessoaDto;
import com.joseluizjunior.cadastropessoa.model.Pessoa;
import com.joseluizjunior.cadastropessoa.model.QPessoa;
import com.joseluizjunior.cadastropessoa.service.PessoaService;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public ResponseEntity<Page<PessoaDto>> getAll(Pageable pageable,
            @RequestParam(defaultValue = "", required = false) String nome,
            @RequestParam(required = false) String cpf) {
        BooleanExpression where = QPessoa.pessoa.nome.toLowerCase().like("%"+nome.toLowerCase()+"%");;
        if (StringUtils.hasText(cpf)) {
            where = where.and(QPessoa.pessoa.cpf.eq(cpf));
        }
        Page<Pessoa> pessoas = pessoaService.findAll(where, pageable);
        return ResponseEntity.ok(pessoas.map(PessoaDto::new));
    }

    @GetMapping("{id}")
    public ResponseEntity<PessoaDto> getPessoa( @PathVariable("id") Long id) {
        Optional<Pessoa> pessoa = pessoaService.findById(id);
        return pessoa.map(p -> ResponseEntity.ok(new PessoaDto(p))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PessoaDto> createPessoa(@RequestBody @Valid PessoaDto pessoaDto, UriComponentsBuilder uriBuilder) {
        Pessoa pessoa = pessoaService.save(PessoaDto.dtoToEntity(pessoaDto));
        URI uri = uriBuilder.path("/pessoas/{id}").buildAndExpand(pessoa.getId()).toUri();
        return ResponseEntity.created(uri).body(new PessoaDto(pessoa));
    }

    @PutMapping("{id}")
    public ResponseEntity<PessoaDto> updatePessoa(@RequestBody @Valid PessoaDto pessoaDto, @PathVariable("id") Long id){
        Pessoa pessoa = pessoaService.update(PessoaDto.dtoToEntity(pessoaDto), id);
        if (Objects.isNull(pessoa)) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(new PessoaDto(pessoa));
    }

    @DeleteMapping("{id}")
    public ResponseEntity deletePessoa(@PathVariable("id") Long id) {
        pessoaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
