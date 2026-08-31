package com.controlegastos.api.service;

import org.springframework.stereotype.Service;
import java.time.LocalDate;
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
        return repository.findAllByOrderByDataDesc();
    }

    public Gasto adicionar(Gasto gasto) {
        return repository.save(gasto);
    }

    public Gasto atualizar(Long id, Gasto dadosAtualizados) {
        Gasto gasto = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Gasto não encontrado: " + id));

        gasto.setDescricao(dadosAtualizados.getDescricao());
        gasto.setValor(dadosAtualizados.getValor());
        gasto.setCategoria(dadosAtualizados.getCategoria());
        gasto.setData(dadosAtualizados.getData());

        return repository.save(gasto);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public List<Gasto> filtrar(LocalDate inicio, LocalDate fim, List<Long> categoriaIds) {
        boolean temData = inicio != null && fim != null;
        boolean temCategoria = categoriaIds != null && !categoriaIds.isEmpty();

        if (temData && temCategoria) {
            return repository.findByDataBetweenAndCategoriaIdInOrderByDataDesc(inicio, fim, categoriaIds);
        } else if (temData) {
            return repository.findByDataBetweenOrderByDataDesc(inicio, fim);
        } else if (temCategoria) {
            return repository.findByCategoriaIdInOrderByDataDesc(categoriaIds);
        } else {
            return repository.findAllByOrderByDataDesc();
        }
    }
}