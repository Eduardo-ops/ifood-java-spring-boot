package br.com.stefanini.stefaninifood.dto.loja;

import br.com.stefanini.stefaninifood.model.Loja;
import br.com.stefanini.stefaninifood.model.Produto;
import br.com.stefanini.stefaninifood.repository.ProdutoRepository;
import br.com.stefanini.stefaninifood.service.LojaService;
import org.hibernate.validator.constraints.Length;

public class AtualizarLojaDto {
    @Length(max = 40)
    private String razaoSocial;
    @Length(max = 60)
    private String endereco;

    private Long idProduto;

    public AtualizarLojaDto() {
    }

    public AtualizarLojaDto(Loja loja) {
        this.razaoSocial = loja.getRazaoSocial();
        this.endereco = loja.getEndereco();
    }

    public Loja converterAtualizar(Long id, AtualizarLojaDto atualizarLojaDto, LojaService lojaService, ProdutoRepository produtoRepository) {
        Loja loja = lojaService.buscarPorId(id);

        if (atualizarLojaDto.getRazaoSocial().isEmpty()) {
            loja.setRazaoSocial(loja.getRazaoSocial());
        } else {
            loja.setRazaoSocial(atualizarLojaDto.getRazaoSocial());
        }
        if (atualizarLojaDto.getEndereco().isEmpty()) {
            loja.setEndereco(loja.getEndereco());
        } else {
            loja.setEndereco(atualizarLojaDto.getEndereco());
        }

        if (atualizarLojaDto.getIdProduto() != null) {
            Produto produto = produtoRepository.findById(atualizarLojaDto.getIdProduto()).get();
            produto.setLoja(loja);
        } else {
            loja.setId(loja.getId());
        }

        return loja;
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

}
