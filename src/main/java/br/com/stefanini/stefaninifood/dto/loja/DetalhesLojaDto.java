package br.com.stefanini.stefaninifood.dto.loja;

import br.com.stefanini.stefaninifood.model.Loja;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class DetalhesLojaDto {

    private Long id;
    private String nome;
    private String razaoSocial;
    private String endereco;
    private String cnpj;

    public DetalhesLojaDto(Loja loja) {
        this.id = loja.getId();
        this.nome = loja.getNome();
        this.razaoSocial = loja.getRazaoSocial();
        this.endereco = loja.getEndereco();
        this.cnpj = loja.getCnpj();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
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
}
