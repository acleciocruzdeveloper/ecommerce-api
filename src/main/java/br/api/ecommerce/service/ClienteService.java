package br.api.ecommerce.service;

import br.api.ecommerce.domain.ClienteModel;
import br.api.ecommerce.domain.EnderecoModel;
import br.api.ecommerce.dto.ClienteDTO;
import br.api.ecommerce.dto.EnderecoDTO;
import br.api.ecommerce.exceptions.ClienteException;
import br.api.ecommerce.repositories.IClienteRepository;
import br.api.ecommerce.repositories.IEnderecoRepository;
import br.api.ecommerce.util.IClientCrud;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ClienteService implements IClientCrud {

    private final IClienteRepository clienteRepository;
    private final IEnderecoRepository enderecoRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ClienteService(IClienteRepository clienteRepository,
                          IEnderecoRepository enderecoRepository, ModelMapper modelMapper) {
        this.clienteRepository = clienteRepository;
        this.enderecoRepository = enderecoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void novoCliente(ClienteDTO clienteDTO) {
        clienteRepository.findByEmail(clienteDTO.getEmailDTO())
                .ifPresent(existing -> {
                    log.error("e-mail ja cadastrado");
                    throw new ClienteException("Cliente ja cadastrado");
                });
        ClienteModel clienteModel = converterClienteDTOParaModel(clienteDTO);

        List<EnderecoModel> enderecosModel = Optional.ofNullable(clienteDTO.getEnderecoDTO())
                .orElse(Collections.emptyList())
                .stream()
                .map(this::converterEnderecoDTOParaModel)
                .collect(Collectors.toList());

        enderecosModel.forEach(endereco -> endereco.setCliente(clienteModel));
        clienteModel.setEnderecos(enderecosModel);

        clienteRepository.save(clienteModel);
        enderecoRepository.saveAll(enderecosModel);
    }

    private ClienteModel converterClienteDTOParaModel(ClienteDTO clienteDTO) {
        return modelMapper.map(clienteDTO, ClienteModel.class);
    }

    private EnderecoModel converterEnderecoDTOParaModel(EnderecoDTO enderecoDTO) {
        return modelMapper.map(enderecoDTO, EnderecoModel.class);
    }

    @Override
    public List<ClienteModel> getAllClientes() {
        return clienteRepository.findAll();
    }

}
