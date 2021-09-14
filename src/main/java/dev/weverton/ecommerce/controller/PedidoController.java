package dev.weverton.ecommerce.controller;

import dev.weverton.ecommerce.domain.Pedido;
import dev.weverton.ecommerce.services.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService){
        this.pedidoService = pedidoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> find(@PathVariable Long id){
        Pedido pedido = pedidoService.find(id);
        return ResponseEntity.ok().body(pedido);
    }
}
