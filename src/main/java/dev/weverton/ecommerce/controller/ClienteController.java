package dev.weverton.ecommerce.controller;

import dev.weverton.ecommerce.domain.Cliente;
import dev.weverton.ecommerce.services.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable Long id){
        Cliente cliente = clienteService.buscar(id);
        return ResponseEntity.ok().body(cliente);
    }
}
