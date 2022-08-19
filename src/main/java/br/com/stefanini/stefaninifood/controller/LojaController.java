package br.com.stefanini.stefaninifood.controller;

import br.com.stefanini.stefaninifood.dto.loja.AtualizarLojaDto;
import br.com.stefanini.stefaninifood.dto.loja.DetalhesLojaDto;
import br.com.stefanini.stefaninifood.dto.loja.LojaDto;
import br.com.stefanini.stefaninifood.dto.loja.LojaFormDto;
import br.com.stefanini.stefaninifood.model.Loja;
import br.com.stefanini.stefaninifood.service.LojaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stefaninifood/lojas")
public class LojaController {

    @Autowired
    private LojaService lojaService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<LojaDto> buscarTodasAsLojas() {
        List<Loja> lojas = lojaService.buscarTodos();
        return lojaService.converterListaParaLojaDto(lojas);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DetalhesLojaDto buscarLojaPorId(@PathVariable Long id) {
        Loja loja = lojaService.buscarPorId(id);
        return new DetalhesLojaDto(loja);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LojaDto criarLoja(@RequestBody LojaFormDto lojaFormDto) {
        Loja loja = this.lojaService.converterParaLoja(lojaFormDto);
        this.lojaService.criarLoja(loja);
        return new LojaDto(loja);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarLoja(@PathVariable Long id, @RequestBody AtualizarLojaDto atualizarLojaDto) {
        Loja loja = this.lojaService.converterAtualizar(id, atualizarLojaDto);
        new LojaDto(lojaService.atualizarLoja(id, loja));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerLoja(@PathVariable Long id) {
        Loja loja = lojaService.buscarPorId(id);
        lojaService.removerLoja(loja);
    }

}
