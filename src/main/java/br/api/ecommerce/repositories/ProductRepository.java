package br.api.ecommerce.repositories;

import br.api.ecommerce.domain.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<ProdutoModel, UUID> {
}
