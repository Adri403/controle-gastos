package com.controlegastos.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.controlegastos.api.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}