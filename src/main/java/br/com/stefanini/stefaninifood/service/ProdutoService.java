package br.com.stefanini.stefaninifood.service;

import br.com.stefanini.stefaninifood.model.Produto;
import br.com.stefanini.stefaninifood.repository.ProdutoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> buscarTodosProdutos() {
        return this.produtoRepository.findAll();
    }

    public Produto buscarPorId(Long id) {
        return this.produtoRepository.findById(id).get();
    }

    @Transactional
    public Produto criarProduto(Produto produto) {
        return this.produtoRepository.save(produto);
    }

    @Transactional
    public Produto atualizarProduto(Long id, Produto produto) {
        Produto produtoById = this.produtoRepository.findById(id).get();
        Produto updatedProduto = new Produto();

        BeanUtils.copyProperties(produto, updatedProduto);
        updatedProduto.setId(produtoById.getId());

        return this.produtoRepository.save(updatedProduto);
    }

    @Transactional
    public void removerProduto(Produto produto) {
        this.produtoRepository.delete(produto);
    }
}
