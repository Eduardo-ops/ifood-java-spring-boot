package br.com.stefanini.stefaninifood.dto.loja;

import br.com.stefanini.stefaninifood.model.Loja;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AtualizarLojaDto {
    @Length(max = 20)
    private String razaoSocial;
    @Length(max = 40)
    private String endereco;

    public AtualizarLojaDto() {
    }

    public AtualizarLojaDto(Loja loja) {
        this.razaoSocial = loja.getRazaoSocial();
        this.endereco = loja.getEndereco();
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
}