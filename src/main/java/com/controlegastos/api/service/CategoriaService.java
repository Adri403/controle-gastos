package com.controlegastos.api.service;

import org.springframework.stereotype.Service;
import java.util.List;
import com.controlegastos.api.model.Categoria;
import com.controlegastos.api.repository.CategoriaRepository;

@Service
public class CategoriaService {

    private final CategoriaRepository repository;

    public CategoriaService(CategoriaRepository repository) {
        this.repository = repository;
    }

    public List<Categoria> listar() {
        return repository.findAll();
    }

    public Categoria adicionar(Categoria categoria) {
        return repository.save(categoria);
    }

    public Categoria atualizar(Long id, Categoria dadosAtualizados) {
        Categoria categoria = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Categoria não encontrada: " + id));
        categoria.setNome(dadosAtualizados.getNome());
        return repository.save(categoria);
    }

    public void deletar(Long id) {  
        repository.deleteById(id);
    }
    
}