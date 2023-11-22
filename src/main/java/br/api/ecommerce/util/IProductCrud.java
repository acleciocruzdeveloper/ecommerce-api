package br.api.ecommerce.util;

import br.api.ecommerce.domain.ProdutoModel;
import br.api.ecommerce.dto.ProdutoDTO;

public interface IProductCrud {

    ProdutoDTO newProduct(ProdutoDTO product);
}
