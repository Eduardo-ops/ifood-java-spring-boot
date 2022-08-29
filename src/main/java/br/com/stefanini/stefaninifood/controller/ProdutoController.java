package br.com.stefanini.stefaninifood.controller;

import br.com.stefanini.stefaninifood.dto.produto.AtualizarProdutoDto;
import br.com.stefanini.stefaninifood.dto.produto.DetalhesProdutoDto;
import br.com.stefanini.stefaninifood.dto.produto.ProdutoDto;
import br.com.stefanini.stefaninifood.dto.produto.ProdutoFormDto;
import br.com.stefanini.stefaninifood.model.Produto;
import br.com.stefanini.stefaninifood.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DetalhesProdutoDto buscarProdutoPorId(@PathVariable Long id) {
        Produto produto = this.produtoService.buscarPorId(id);
        return new DetalhesProdutoDto(produto);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoDto criarProduto(@RequestBody @Valid ProdutoFormDto produtoFormDto) {
        Produto produto = produtoFormDto.converterParaProduto(produtoFormDto);
        this.produtoService.criarProduto(produto);
        return new ProdutoDto(produto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void atualizarProduto(@PathVariable Long id, @RequestBody @Valid AtualizarProdutoDto atualizarProdutoDto) {
        Produto produto = atualizarProdutoDto.converterAtualizar(id, atualizarProdutoDto, this.produtoService);
        new ProdutoDto(produtoService.atualizarProduto(id, produto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void removerProduto(@PathVariable Long id) {
        Produto produto = produtoService.buscarPorId(id);
        produtoService.removerProduto(produto);
    }
}
