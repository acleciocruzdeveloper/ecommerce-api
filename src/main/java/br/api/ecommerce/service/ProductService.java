package br.api.ecommerce.service;

import br.api.ecommerce.domain.ProdutoModel;
import br.api.ecommerce.dto.ProdutoDTO;
import br.api.ecommerce.enumerates.Secao;
import br.api.ecommerce.repositories.ProductRepository;
import br.api.ecommerce.util.IProductCrud;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    public ProdutoDTO novoProduto(ProdutoDTO produto) {
        ProdutoModel model = toPordutoModel(produto);
        repository.save(model);
        return produto;
    }

    @Override
    public List<ProdutoDTO> todosProdutos() {
        List<ProdutoModel> produtos = repository.findAll();

        return produtos.stream().map(
                this::toProdutoDTO
        ).collect(Collectors.toList());
    }

    @Override
    public List<ProdutoDTO> produtosPorSecao(String secao) {
        List<ProdutoModel> byProdutoPorSecao = repository
                .findProdutosBySecao(Secao.valueOf(secao.toUpperCase()));

        return byProdutoPorSecao.stream().map(
                this::toProdutoDTO
        ).collect(Collectors.toList());
    }

    private ProdutoModel toPordutoModel(ProdutoDTO dto) {
        return mapper.map(dto, ProdutoModel.class);
    }

    private ProdutoDTO toProdutoDTO(ProdutoModel model) {
        ProdutoDTO produtoDTO = mapper.map(model, ProdutoDTO.class);
        produtoDTO.setSecao(model.getSecao().getValue());
        return produtoDTO;
    }

}
