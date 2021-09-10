package dev.weverton.ecommerce.repositories;

import dev.weverton.ecommerce.domain.Categoria;
import dev.weverton.ecommerce.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
