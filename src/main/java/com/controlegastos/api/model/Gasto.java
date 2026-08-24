package com.controlegastos.api.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "gasto")
public class Gasto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;
    private Double valor;
    private String categoria;

    private LocalDate data;

    // 🔹 CONSTRUTOR VAZIO (OBRIGATÓRIO pro JPA)
    public Gasto() {
    }

    // 🔹 CONSTRUTOR OPCIONAL
    public Gasto(String descricao, Double valor, String categoria, LocalDate data) {
        this.descricao = descricao;
        this.valor = valor;
        this.categoria = categoria;
        this.data = data;
    }

    // 🔹 GETTERS E SETTERS

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}