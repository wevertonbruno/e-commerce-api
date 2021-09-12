package dev.weverton.ecommerce.services;

import dev.weverton.ecommerce.domain.Categoria;
import dev.weverton.ecommerce.repositories.CategoriaRepository;
import dev.weverton.ecommerce.exceptions.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    private CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria find(Long id){
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        return categoria.orElseThrow(
                () -> new EntityNotFoundException("Categoria(" + id +") não encontrada"));
   }

   public Categoria store(Categoria categoriaObj){
        categoriaObj.setId(null);
        return categoriaRepository.save(categoriaObj);
   }
}
