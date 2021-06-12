package com.joseluizjunior.cadastropessoa.repository;

import com.joseluizjunior.cadastropessoa.model.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PaisRepository extends JpaRepository<Pais, Long> {
}
