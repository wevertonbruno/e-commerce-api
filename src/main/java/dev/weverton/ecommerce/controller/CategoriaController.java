package dev.weverton.ecommerce.controller;

import dev.weverton.ecommerce.domain.Categoria;
import dev.weverton.ecommerce.services.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService){
        this.categoriaService = categoriaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> find(@PathVariable Long id){
        Categoria categoria = categoriaService.find(id);
        return ResponseEntity.ok().body(categoria);
    }

    @PostMapping
    public ResponseEntity<Categoria> store(@RequestBody Categoria categoriaObj){
        Categoria categoria = categoriaService.store(categoriaObj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(categoria);
    }
}
