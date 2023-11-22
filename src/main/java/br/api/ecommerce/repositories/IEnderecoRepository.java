package br.api.ecommerce.repositories;

import br.api.ecommerce.domain.EnderecoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IEnderecoRepository extends JpaRepository<EnderecoModel, UUID> {
}
