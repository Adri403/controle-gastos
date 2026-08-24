package com.controlegastos.api.service;

import org.springframework.stereotype.Service;
import java.util.*;
import com.controlegastos.api.model.Gasto;
import com.controlegastos.api.repository.GastoRepository;

@Service
public class GastoService {

    private final GastoRepository repository;

    public GastoService(GastoRepository repository) {
        this.repository = repository;
    }

    public List<Gasto> listar() {
        return repository.findAll();
    }

    public Gasto adicionar(Gasto gasto) {
        return repository.save(gasto);
    }
}