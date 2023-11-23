package br.api.ecommerce.dto;

import br.api.ecommerce.enumerates.Secao;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProdutoDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 5901245304464615708L;

    private String secao;
    private String nome;
    private BigDecimal valorUnitario;

}
