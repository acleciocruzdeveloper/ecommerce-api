package br.api.ecommerce.dto;

import br.api.ecommerce.enumerates.TypeAddress;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EnderecoDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = -6761211554561181459L;

    private TypeAddress tipoEndereco;
    private String cep;
    private String endereco;
    private int numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
}
