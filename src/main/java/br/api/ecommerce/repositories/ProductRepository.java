package br.api.ecommerce.repositories;

import br.api.ecommerce.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Produto, UUID> {
}
