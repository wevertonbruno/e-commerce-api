package dev.weverton.ecommerce.services;

import dev.weverton.ecommerce.domain.Cliente;
import dev.weverton.ecommerce.exceptions.EntityNotFoundException;
import dev.weverton.ecommerce.repositories.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente buscar(Long id){
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.orElseThrow(
                () -> new EntityNotFoundException("Cliente(" + id +") não encontrado"));
   }
}
