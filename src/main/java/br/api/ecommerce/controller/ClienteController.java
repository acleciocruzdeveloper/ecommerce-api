package br.api.ecommerce.controller;

import br.api.ecommerce.domain.ClienteModel;
import br.api.ecommerce.dto.ClienteDTO;
import br.api.ecommerce.dto.EnderecoDTO;
import br.api.ecommerce.exceptions.ClienteException;
import br.api.ecommerce.service.ClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/ecommerce")
@Api(value = "Clientes", tags = "E-Commerce")
public class ClienteController {

    private final ClienteService service;

    @Autowired
    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @PostMapping("/clientes")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "cadastrar novo cliente")
    public ResponseEntity<ClienteDTO> createdCliente(@RequestBody ClienteDTO clienteDTO) {
        try {
            service.novoCliente(clienteDTO);
            return new ResponseEntity<>(clienteDTO, HttpStatus.CREATED);
        } catch (ClienteException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/clientes")
    public ResponseEntity<List<ClienteModel>> getAll() {
        List<ClienteModel> allClientes = service.getAllClientes();
        return ResponseEntity.ok(allClientes);
    }

    @ExceptionHandler(ClienteException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleClienteException(ClienteException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
