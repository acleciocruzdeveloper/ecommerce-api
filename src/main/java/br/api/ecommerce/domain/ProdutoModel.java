package br.api.ecommerce.domain;

import br.api.ecommerce.enumerates.Secao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "produto")
public class ProdutoModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 4523784053991839641L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private Secao secao;
    private String produto;
    private BigDecimal valorUnitario;
    private int quantidade;
    private int totalItems;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pedido_id")
    private PedidoModel pedido;
}
