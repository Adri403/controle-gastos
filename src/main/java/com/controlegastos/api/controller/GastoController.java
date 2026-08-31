package com.controlegastos.api.controller;

import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.*;
import com.controlegastos.api.model.Gasto;
import com.controlegastos.api.service.GastoService;

@RestController
@RequestMapping("/gastos")
public class GastoController {

    private final GastoService service;

    public GastoController(GastoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Gasto> listar() {
        return service.listar();
    }

    @PostMapping
    public Gasto adicionar(@RequestBody Gasto gasto) {
        return service.adicionar(gasto);
    }

    @PutMapping("/{id}")
    public Gasto atualizar(@PathVariable Long id, @RequestBody Gasto gasto) {
        return service.atualizar(id, gasto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

    @GetMapping("/filtro")
    public List<Gasto> filtrar(
        @RequestParam(required = false) LocalDate inicio,
        @RequestParam(required = false) LocalDate fim,
        @RequestParam(required = false) List<Long> categoriaIds) {
        return service.filtrar(inicio, fim, categoriaIds);
    }
}