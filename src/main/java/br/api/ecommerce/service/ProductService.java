package br.api.ecommerce.service;

import br.api.ecommerce.domain.ProdutoModel;
import br.api.ecommerce.dto.ProdutoDTO;
import br.api.ecommerce.repositories.ProductRepository;
import br.api.ecommerce.util.IProductCrud;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductService implements IProductCrud {

    private final ProductRepository repository;
    private final ModelMapper mapper;

    @Autowired
    public ProductService(ProductRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ProdutoDTO newProduct(ProdutoDTO produto) {
        ProdutoModel model = toProdutoDTO(produto);
        repository.save(model);
        return produto;
    }

    private ProdutoModel toProdutoDTO(ProdutoDTO dto){
        return mapper.map(dto, ProdutoModel.class);
    }

}
