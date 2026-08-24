package com.controlegastos.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.controlegastos.api.model.Gasto;

public interface GastoRepository extends JpaRepository<Gasto, Long> {
}