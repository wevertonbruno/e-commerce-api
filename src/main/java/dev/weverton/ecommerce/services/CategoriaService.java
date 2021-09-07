package dev.weverton.ecommerce.services;

import dev.weverton.ecommerce.domain.Categoria;
import dev.weverton.ecommerce.repositories.CategoriaRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    private CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria buscar(Long id){
        Categoria categoria = categoriaRepository.findById(id).get();
        return categoria;
    }
}
