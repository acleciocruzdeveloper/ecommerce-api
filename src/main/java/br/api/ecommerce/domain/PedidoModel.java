package br.api.ecommerce.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pedido")
@JsonIgnoreProperties(ignoreUnknown = true)
public class PedidoModel implements Serializable {

    @Serial
    private static final long serialVersionUID = -4534836895370221144L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int totalDeItems;
    private boolean entrega;
    private BigDecimal valorEntrega;
    private BigDecimal totalDoPedido;
    private BigDecimal totalPago;
    private BigDecimal troco;

    private LocalDateTime dataPedido;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteModel cliente;
}
