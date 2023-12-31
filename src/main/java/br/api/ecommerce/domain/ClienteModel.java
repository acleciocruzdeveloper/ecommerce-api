package br.api.ecommerce.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "clientes")
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "uuid", updatable = false)
    private UUID id;

    @Column(name = "nome")
    @NotNull(message = "First name cannot be null")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email", unique = true)
    @Email(regexp = ".*@.*\\..*", message = "Email should be valid")
    private String email;

    @Column(name = "telefone")
    private String telefone;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "cliente_id")
    private List<EnderecoModel> enderecos;

    @Column(name = "data_registro")
    private LocalDateTime dataRegistro;

    public ClienteModel() {
        this.dataRegistro = LocalDateTime.now();
    }
}
