package br.com.stefanini.stefaninifood.service;

import br.com.stefanini.stefaninifood.model.Produto;
import br.com.stefanini.stefaninifood.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> buscarTodosProdutos() {
        return this.produtoRepository.findAll();
    }
}
