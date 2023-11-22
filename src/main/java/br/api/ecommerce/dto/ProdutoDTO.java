package br.api.ecommerce.dto;

import br.api.ecommerce.enumerates.Secao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProdutoDTO {

    private String item;
    private int quantidade;
    private BigDecimal valorUnitario;
    private BigDecimal totalItem;
}
