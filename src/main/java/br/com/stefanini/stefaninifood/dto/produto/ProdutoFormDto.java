package br.com.stefanini.stefaninifood.dto.produto;

import br.com.stefanini.stefaninifood.model.Produto;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ProdutoFormDto {

    @NotNull
    @NotEmpty
    @Length(max = 20)
    private String nome;

    @NotNull
    private float valor;

    public Produto converterParaProduto(ProdutoFormDto produtoFormDto) {
        return new Produto(produtoFormDto.getNome(), produtoFormDto.getValor());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
}
