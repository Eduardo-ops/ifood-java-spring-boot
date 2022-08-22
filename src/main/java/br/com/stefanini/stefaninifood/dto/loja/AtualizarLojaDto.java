package br.com.stefanini.stefaninifood.dto.loja;

import br.com.stefanini.stefaninifood.model.Loja;
import br.com.stefanini.stefaninifood.model.Produto;
import org.hibernate.validator.constraints.Length;

import java.util.List;

public class AtualizarLojaDto {
    @Length(max = 40)
    private String razaoSocial;
    @Length(max = 60)
    private String endereco;

    private Long idProduto;

    private List<Produto> produtos;

    public AtualizarLojaDto() {
    }

    public AtualizarLojaDto(Loja loja) {
        this.razaoSocial = loja.getRazaoSocial();
        this.endereco = loja.getEndereco();
        this.produtos = loja.getProdutos();
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

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
