package br.com.stefanini.stefaninifood.controller;

import br.com.stefanini.stefaninifood.model.Produto;
import br.com.stefanini.stefaninifood.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/stefaninifood/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Produto> buscarTodosProdutos() {
        return this.produtoService.buscarTodosProdutos();
    }
}
