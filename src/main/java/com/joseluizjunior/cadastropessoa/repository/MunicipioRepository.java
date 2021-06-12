package com.joseluizjunior.cadastropessoa.repository;

import com.joseluizjunior.cadastropessoa.model.Municipio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface MunicipioRepository extends JpaRepository<Municipio, Long>, QuerydslPredicateExecutor<Municipio> {
}
