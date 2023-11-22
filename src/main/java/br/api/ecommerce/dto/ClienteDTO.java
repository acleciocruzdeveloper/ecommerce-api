package br.api.ecommerce.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClienteDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 8714532447785598898L;

    private String nome;
    private String lastNameDTO;
    private String emailDTO;
    private String telefoneDTO;
    private List<EnderecoDTO> enderecoDTO;
}
