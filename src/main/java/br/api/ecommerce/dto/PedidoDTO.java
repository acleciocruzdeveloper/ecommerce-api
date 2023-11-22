package br.api.ecommerce.dto;

import br.api.ecommerce.enumerates.Secao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PedidoDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = -7969144836681069750L;

    private ClienteDTO clienteDTO;
    private List<EnderecoDTO> enderecoDTOS = new ArrayList<>();
    private List<PedidoDTO> pedidoDTOS = new ArrayList<>();

    private Secao produtos;
    private int totalDeItems;
    private BigDecimal totaDoPedido;
    private BigDecimal descontoPromocional;
    private BigDecimal valorPago;
    private BigDecimal troco;

    private LocalDateTime dataDoPedido;
}
