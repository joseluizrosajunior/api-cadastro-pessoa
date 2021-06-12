package com.joseluizjunior.cadastropessoa.service;

import com.joseluizjunior.cadastropessoa.model.Pessoa;
import com.joseluizjunior.cadastropessoa.repository.PessoaRepository;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa save(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    @Transactional
    public Pessoa update(Pessoa pessoa, Long id) {
        boolean pessoaExists = pessoaRepository.existsById(id);
        if (pessoaExists && id.equals(pessoa.getId())) {
            return save(pessoa);
        }
        return null;
    }

    public void delete(long id) {
        pessoaRepository.deleteById(id);
    }

    public Page<Pessoa> findAll(Pageable pageable) {
        return pessoaRepository.findAll(pageable);
    }

    public Page<Pessoa> findAll(Predicate predicate, Pageable pageable) {
        if (Objects.isNull(predicate)) {
            return findAll(pageable);
        }
        return pessoaRepository.findAll(predicate, pageable);
    }

    public Optional<Pessoa> findById(Long id) {
        return pessoaRepository.findById(id);
    }
}
