package com.joseluizjunior.cadastropessoa.service;

import com.google.common.collect.Lists;
import com.joseluizjunior.cadastropessoa.model.Municipio;
import com.joseluizjunior.cadastropessoa.repository.MunicipioRepository;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class MunicipioService {

    @Autowired
    private MunicipioRepository municipioRepository;

    public List<Municipio> findAll(Predicate predicate) {
        return Lists.newArrayList(municipioRepository.findAll(predicate));
    }
}
