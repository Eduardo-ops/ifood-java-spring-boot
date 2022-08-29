package br.com.stefanini.stefaninifood.dto.produto;

import br.com.stefanini.stefaninifood.model.Produto;
import br.com.stefanini.stefaninifood.service.ProdutoService;

public class AtualizarProdutoDto {

    private String nome;
    private float valor;
    private String descricao;

    public AtualizarProdutoDto() {

    }

    public AtualizarProdutoDto(Produto produto) {
        this.nome = produto.getNome();
        this.valor = produto.getValor();
        this.descricao = produto.getDescricao();
    }

    public Produto converterAtualizar(Long id, AtualizarProdutoDto atualizarProdutoDto, ProdutoService produtoService) {
        Produto produto = produtoService.buscarPorId(id);

        produto.setNome(atualizarProdutoDto.getNome());
        produto.setValor(atualizarProdutoDto.getValor());
        produto.setDescricao(atualizarProdutoDto.getDescricao());

        return produto;
    }

    public Produto converter() {
        return new Produto();
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
