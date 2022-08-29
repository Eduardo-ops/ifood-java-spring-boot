package br.com.stefanini.stefaninifood.dto.cliente;

import br.com.stefanini.stefaninifood.model.Cliente;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ClienteFormDto {

    @NotNull
    @NotEmpty
    @Length(max = 40)
    private String nome;

    @Length(max = 11)
    private String cpf;

    @Length(max = 80)
    private String endereco;

    public Cliente converterParaCliente(ClienteFormDto clienteFormDto) {
        return new Cliente(clienteFormDto.getNome(), clienteFormDto.getCpf(), clienteFormDto.getEndereco());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
