package br.api.ecommerce.util;

import br.api.ecommerce.domain.ClienteModel;
import br.api.ecommerce.dto.ClienteDTO;
import br.api.ecommerce.dto.EnderecoDTO;

import javax.transaction.Transactional;
import java.util.List;

public interface IClientCrud {

    @Transactional
    void novoCliente(ClienteDTO clienteDTO);

    List<ClienteDTO> getAllClientes();
}
