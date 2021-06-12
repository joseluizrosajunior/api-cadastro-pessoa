package com.joseluizjunior.cadastropessoa.repository;

import com.joseluizjunior.cadastropessoa.model.Pessoa;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PessoaRepository extends PagingAndSortingRepository<Pessoa, Long>, JpaSpecificationExecutor<Pessoa>, QuerydslPredicateExecutor<Pessoa> {
}
