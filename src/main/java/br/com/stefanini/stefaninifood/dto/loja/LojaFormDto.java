package br.com.stefanini.stefaninifood.dto.loja;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class LojaFormDto {

    @NotNull
    @NotEmpty
    @Length(max = 20)
    private String nome;

    @NotNull
    @NotEmpty
    @Length(max = 80)
    private String endereco;

    @NotNull
    @NotEmpty
    @Length(min = 18, max = 18)
    private String cnpj;

    @NotNull
    private Long idProduto;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }
}
