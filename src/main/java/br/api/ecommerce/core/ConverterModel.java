package br.api.ecommerce.core;

import br.api.ecommerce.domain.ClienteModel;
import br.api.ecommerce.domain.EnderecoModel;
import br.api.ecommerce.dto.ClienteDTO;
import br.api.ecommerce.dto.EnderecoDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.List;

@Component
public class ConverterModel {

    private final ModelMapper modelMapper;

    public ConverterModel(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


}
