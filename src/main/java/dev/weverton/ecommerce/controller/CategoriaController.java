package dev.weverton.ecommerce.controller;

import dev.weverton.ecommerce.domain.Categoria;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @GetMapping
    public List<Categoria> listar(){
        Categoria c1 = new Categoria(1, "Informatica");
        Categoria c2 = new Categoria(2, "Escritório");
        List<Categoria> list = List.of(c1, c2);
        return list;
    }
}
