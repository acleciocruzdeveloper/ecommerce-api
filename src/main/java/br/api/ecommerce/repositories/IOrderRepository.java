package br.api.ecommerce.repositories;

import br.api.ecommerce.domain.PedidoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<PedidoModel, Long> {
}
