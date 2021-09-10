package dev.weverton.ecommerce.services;

import dev.weverton.ecommerce.domain.Pedido;
import dev.weverton.ecommerce.exceptions.EntityNotFoundException;
import dev.weverton.ecommerce.repositories.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

    private PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public Pedido buscar(Long id){
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        return pedido.orElseThrow(
                () -> new EntityNotFoundException("Pedido(" + id +") não encontrado"));
   }
}
