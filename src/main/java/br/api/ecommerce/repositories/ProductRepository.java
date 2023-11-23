package br.api.ecommerce.repositories;

import br.api.ecommerce.domain.ProdutoModel;
import br.api.ecommerce.enumerates.Secao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<ProdutoModel, UUID> {

    @Query("SELECT p FROM ProdutoModel p WHERE p.secao=:secao")
    List<ProdutoModel> findProdutosBySecao(@Param("secao") Secao secao);
}
