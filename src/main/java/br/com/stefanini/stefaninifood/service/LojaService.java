package br.com.stefanini.stefaninifood.service;

import br.com.stefanini.stefaninifood.dto.loja.AtualizarLojaDto;
import br.com.stefanini.stefaninifood.dto.loja.LojaDto;
import br.com.stefanini.stefaninifood.dto.loja.LojaFormDto;
import br.com.stefanini.stefaninifood.model.Loja;
import br.com.stefanini.stefaninifood.model.Produto;
import br.com.stefanini.stefaninifood.repository.LojaRepository;
import br.com.stefanini.stefaninifood.repository.ProdutoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LojaService {

    @Autowired
    private LojaRepository lojaRepository;
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Loja> buscarTodos() {
        return this.lojaRepository.findAll();
    }

    public List<LojaDto> converterListaParaLojaDto(List<Loja> lojas) {
        return lojas.stream().map(LojaDto::new).collect(Collectors.toList());
    }

    public Loja buscarPorId(Long id) {
        return this.lojaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Loja não encontrado"));
    }

    @Transactional
    public Loja criarLoja(Loja loja) {

        return lojaRepository.save(loja);
    }

    public Loja converterParaLoja(LojaFormDto lojaFormDto) {
        List<Produto> produtos = new ArrayList<>();
        Produto produto = this.produtoRepository.findById(lojaFormDto.getIdProduto()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));
        produtos.add(produto);
        return new Loja(lojaFormDto.getNome(), lojaFormDto.getEndereco(), lojaFormDto.getCnpj(), produtos);
    }

    @Transactional
    public Loja atualizarLoja(Long id, Loja loja) {
        Loja lojaById = lojaRepository.findById(id).get();
        Loja updateLoja = new Loja();

        BeanUtils.copyProperties(loja, updateLoja);
        updateLoja.setId(lojaById.getId());

        return this.lojaRepository.save(updateLoja);

//        lojaById.setNome(loja.getNome());
//        lojaById.setRazaoSocial(loja.getRazaoSocial());
//        lojaById.setEndereco(loja.getEndereco());
//        lojaById.setCnpj(loja.getCnpj());
//        return this.lojaRepository.save(lojaById);
    }

    @Transactional
    public Loja converterAtualizar(Long id, AtualizarLojaDto atualizarLojaDto) {
        Loja loja = buscarPorId(id);

        loja.setRazaoSocial(atualizarLojaDto.getRazaoSocial());
        loja.setEndereco(atualizarLojaDto.getEndereco());

        Produto produto = this.produtoRepository.findById(atualizarLojaDto.getIdProduto()).get();

        List<Produto> produtos = new ArrayList<>();
        produtos = loja.getProdutos();
        produtos.add(produto);

        loja.setProdutos(produtos);

        return loja;
    }


    @Transactional
    public void removerLoja(Loja loja) {
        this.lojaRepository.delete(loja);
    }
}
