package br.api.ecommerce.util;

import br.api.ecommerce.dto.ProdutoDTO;

import java.util.List;

public interface IProductCrud {

    ProdutoDTO novoProduto(ProdutoDTO product);

    List<ProdutoDTO> todosProdutos();

    List<ProdutoDTO> produtosPorSecao(String secao);
}
