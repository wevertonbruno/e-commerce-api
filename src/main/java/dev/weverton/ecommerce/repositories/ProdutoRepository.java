package dev.weverton.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.weverton.ecommerce.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
