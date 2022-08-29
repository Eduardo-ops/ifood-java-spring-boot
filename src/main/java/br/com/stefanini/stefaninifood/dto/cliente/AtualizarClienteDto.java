package br.com.stefanini.stefaninifood.dto.cliente;

import br.com.stefanini.stefaninifood.model.Cliente;
import br.com.stefanini.stefaninifood.service.ClienteService;
import org.hibernate.validator.constraints.Length;

public class AtualizarClienteDto {
    @Length(max = 14)
    private String telefone;
    @Length(max = 40)
    private String email;
    @Length(max = 60)
    private String endereco;

    public AtualizarClienteDto() {

    }

    public AtualizarClienteDto(Cliente cliente) {
        this.telefone = cliente.getTelefone();
        this.email = cliente.getEmail();
        this.endereco = cliente.getEndereco();
    }

    public Cliente converterParaCliente(Long id, AtualizarClienteDto atualizarClienteDto, ClienteService clienteService) {
        Cliente cliente = clienteService.buscarClientePorId(id);

        cliente.setTelefone(atualizarClienteDto.getTelefone());
        cliente.setEmail(atualizarClienteDto.getEmail());
        cliente.setEndereco(atualizarClienteDto.getEndereco());

        return cliente;
    }

    public Cliente converterAtualizar(Long id, AtualizarClienteDto atualizarClienteDto, ClienteService clienteService) {
        Cliente cliente = clienteService.buscarClientePorId(id);

        cliente.setTelefone(atualizarClienteDto.getTelefone());
        cliente.setEmail(atualizarClienteDto.getEmail());
        cliente.setEndereco(atualizarClienteDto.getEndereco());

        return cliente;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
