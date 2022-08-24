package br.com.stefanini.stefaninifood.service;

import br.com.stefanini.stefaninifood.dto.loja.LojaDto;
import br.com.stefanini.stefaninifood.model.Loja;
import br.com.stefanini.stefaninifood.repository.LojaRepository;
import br.com.stefanini.stefaninifood.repository.ProdutoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
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

    @Transactional
    public Loja atualizarLoja(Long id, Loja loja) {
        Loja lojaById = lojaRepository.findById(id).get();
        Loja updateLoja = new Loja();

        BeanUtils.copyProperties(loja, updateLoja);
        updateLoja.setId(lojaById.getId());

        return this.lojaRepository.save(updateLoja);
    }

    @Transactional
    public void removerLoja(Loja loja) {
        this.lojaRepository.delete(loja);
    }
}
