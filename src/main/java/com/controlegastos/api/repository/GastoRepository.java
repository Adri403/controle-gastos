package com.controlegastos.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.controlegastos.api.model.Gasto;
import java.time.LocalDate;
import java.util.List;

public interface GastoRepository extends JpaRepository<Gasto, Long> {

    List<Gasto> findByDataBetweenAndCategoriaIdInOrderByDataDesc(LocalDate inicio, LocalDate fim, List<Long> categoriaIds);
    List<Gasto> findByDataBetweenOrderByDataDesc(LocalDate inicio, LocalDate fim);
    List<Gasto> findByCategoriaIdInOrderByDataDesc(List<Long> categoriaIds);
    List<Gasto> findAllByOrderByDataDesc();
}