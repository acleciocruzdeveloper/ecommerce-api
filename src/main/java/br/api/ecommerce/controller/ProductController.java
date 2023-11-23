package br.api.ecommerce.controller;

import br.api.ecommerce.dto.ProdutoDTO;
import br.api.ecommerce.enumerates.Secao;
import br.api.ecommerce.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ProdutoDTO> createProducts(@RequestBody ProdutoDTO productDTO) {
        return ResponseEntity.ok(service.novoProduto(productDTO));
    }

    @GetMapping("/produtos")
    @ApiOperation(value = "buscar lista de produtos")
    public ResponseEntity<List<ProdutoDTO>> getAll(){
        List<ProdutoDTO> produtoDTOS = service.todosProdutos();
        return ResponseEntity.ok(produtoDTOS);
    }

    @GetMapping("/produtos/{secao}")
    @ApiOperation(value = "buscar lista de produtos por secao")
    public ResponseEntity<List<ProdutoDTO>> todosPorSecao(@PathVariable String secao){
        List<ProdutoDTO> porSecao = service.produtosPorSecao(secao);
        return ResponseEntity.ok(porSecao);
    }
}
