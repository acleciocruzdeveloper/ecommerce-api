package br.api.ecommerce.util;

import br.api.ecommerce.domain.Produto;
import br.api.ecommerce.dto.ProdutoDTO;

public interface IProductCrud {

    Produto newProduct(ProdutoDTO product);
}
