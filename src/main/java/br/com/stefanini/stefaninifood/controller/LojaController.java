package br.com.stefanini.stefaninifood.controller;

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
    public List<Loja> findAllLojas() {
        return lojaService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Loja findById(@PathVariable Long id) {
        return lojaService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Loja createLoja(@RequestBody Loja loja) {
        return lojaService.createLoja(loja);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateLoja(@PathVariable Long id, @RequestBody Loja loja) {
        lojaService.updatedLoja(id, loja);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeLoja(@PathVariable Long id) {
        Loja loja = lojaService.findById(id);
        lojaService.removeLoja(loja);
    }

}
