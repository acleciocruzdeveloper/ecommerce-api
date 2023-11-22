package br.api.ecommerce.repositories;

import br.api.ecommerce.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<Pedido, Long> {
}
