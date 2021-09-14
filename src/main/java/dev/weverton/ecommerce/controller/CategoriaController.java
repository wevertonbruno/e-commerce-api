package dev.weverton.ecommerce.controller;

import dev.weverton.ecommerce.domain.Categoria;
import dev.weverton.ecommerce.dto.CategoriaDTO;
import dev.weverton.ecommerce.services.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService){
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> findAll(){
        List<CategoriaDTO> categorias = categoriaService.findAll();
        return ResponseEntity.ok().body(categorias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> find(@PathVariable Long id){
        Categoria categoria = categoriaService.find(id);
        return ResponseEntity.ok().body(categoria);
    }

    @PostMapping
    public ResponseEntity<Void> store(@Valid @RequestBody CategoriaDTO categoriaDTO){
        Categoria categoria = categoriaService.store(categoriaDTO.toEntity());
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(categoria.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody CategoriaDTO categoriaDTO, @PathVariable Long id){
        categoriaDTO.setId(id);
        Categoria categoria = categoriaService.update(categoriaDTO.toEntity());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        categoriaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
