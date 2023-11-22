package br.api.ecommerce.repositories;

import br.api.ecommerce.domain.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface IClienteRepository extends JpaRepository<ClienteModel, UUID> {
    Optional<ClienteModel> findByEmail(String email);
}
