package br.api.ecommerce.service;

import br.api.ecommerce.domain.Produto;
import br.api.ecommerce.dto.ProdutoDTO;
import br.api.ecommerce.repositories.ProductRepository;
import br.api.ecommerce.util.IProductCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductService implements IProductCrud {

    private final ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Produto newProduct(ProdutoDTO product) {
        Produto prod = Produto.builder()
                .id(UUID.randomUUID())
                .build();
        return repository.save(prod);
    }

}
