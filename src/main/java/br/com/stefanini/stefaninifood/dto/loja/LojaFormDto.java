package br.com.stefanini.stefaninifood.dto.loja;

import br.com.stefanini.stefaninifood.model.Loja;
import br.com.stefanini.stefaninifood.model.Produto;
import br.com.stefanini.stefaninifood.repository.ProdutoRepository;
import org.hibernate.validator.constraints.Length;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

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

    public Loja converterParaLoja(LojaFormDto lojaFormDto, ProdutoRepository produtoRepository) {
        List<Produto> produtos = new ArrayList<>();
        Produto produto = produtoRepository.findById(lojaFormDto.getIdProduto()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));
        produtos.add(produto);
        return new Loja(lojaFormDto.getNome(), lojaFormDto.getEndereco(), lojaFormDto.getCnpj(), produtos);
    }

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
