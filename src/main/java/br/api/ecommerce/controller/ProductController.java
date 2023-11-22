package br.api.ecommerce.controller;

import br.api.ecommerce.domain.Produto;
import br.api.ecommerce.dto.ProdutoDTO;
import br.api.ecommerce.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/ecommerce")
@Api(value = "Produtos", tags = "E-Commerce")
public class ProductController {

    private final ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping("/produtos")
    @ApiOperation(value = "registrar novo produto")
    public ResponseEntity<Produto> createProducts(@RequestBody ProdutoDTO productDTO) {
        Produto product = service.newProduct(productDTO);
        return ResponseEntity.ok(product);

    }
}
