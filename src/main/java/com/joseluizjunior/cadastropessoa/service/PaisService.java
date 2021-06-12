package com.joseluizjunior.cadastropessoa.service;

import com.joseluizjunior.cadastropessoa.model.Pais;
import com.joseluizjunior.cadastropessoa.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaisService {

    @Autowired
    private PaisRepository paisRepository;

    public List<Pais> findAll() {
        return paisRepository.findAll();
    }
}
