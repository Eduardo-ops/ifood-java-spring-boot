package br.com.stefanini.stefaninifood.controller;

import br.com.stefanini.stefaninifood.dto.cliente.AtualizarClienteDto;
import br.com.stefanini.stefaninifood.dto.cliente.ClienteDto;
import br.com.stefanini.stefaninifood.dto.cliente.ClienteFormDto;
import br.com.stefanini.stefaninifood.dto.cliente.DetalhesClienteDto;
import br.com.stefanini.stefaninifood.model.Cliente;
import br.com.stefanini.stefaninifood.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/stefaninifood/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ClienteDto> buscarTodosClientes() {
        List<Cliente> clientes = this.clienteService.buscarTodosClientes();
        return ClienteDto.converterParaClientes(clientes);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DetalhesClienteDto buscarClientePorId(@PathVariable Long id) {
        Cliente cliente = this.clienteService.buscarClientePorId(id);
        return new DetalhesClienteDto(cliente);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteDto criarCliente(@RequestBody @Valid ClienteFormDto clienteFormDto) {
        Cliente cliente = clienteFormDto.converterParaCliente(clienteFormDto);
        this.clienteService.criarCliente(cliente);
        return new ClienteDto(cliente);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void atualizarCliente(@PathVariable Long id, @RequestBody @Valid AtualizarClienteDto atualizarClienteDtoDto) {
        Cliente cliente = atualizarClienteDtoDto.converterParaCliente(id, atualizarClienteDtoDto, this.clienteService);
        new ClienteDto(this.clienteService.atualizarCliente(id, cliente));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void removerCliente(@PathVariable Long id) {
        Cliente cliente = this.clienteService.buscarClientePorId(id);
        this.clienteService.removerCliente(cliente);
    }

}
