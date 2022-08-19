package br.com.stefanini.stefaninifood.dto.loja;

import br.com.stefanini.stefaninifood.model.Loja;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

public class LojaDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String razaoSocial;
    private String endereco;
    private String cnpj;
    private LocalDateTime dataDeRegistro;

    public LojaDto() {
    }

    public LojaDto(Loja loja) {
        this.id = loja.getId();
        this.nome = loja.getNome();
        this.razaoSocial = loja.getRazaoSocial();
        this.endereco = loja.getEndereco();
        this.cnpj = loja.getCnpj();
        this.dataDeRegistro = loja.getDataDeRegistro();
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

    public LocalDateTime getDataDeRegistro() {
        return dataDeRegistro;
    }

    public void setDataDeRegistro(LocalDateTime dataDeRegistro) {
        this.dataDeRegistro = dataDeRegistro;
    }
}
