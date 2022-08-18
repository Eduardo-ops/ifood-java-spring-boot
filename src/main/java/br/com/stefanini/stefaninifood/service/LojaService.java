package br.com.stefanini.stefaninifood.service;

import br.com.stefanini.stefaninifood.model.Loja;
import br.com.stefanini.stefaninifood.repository.LojaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class LojaService {

    @Autowired
    private LojaRepository lojaRepository;

    public List<Loja> findAll() {
        return this.lojaRepository.findAll();
    }

    public Loja findById(Long id) {
        return this.lojaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Loja não encontrado"));
    }

    @Transactional
    public Loja createLoja(Loja loja) {
        return this.lojaRepository.save(loja);
    }

    @Transactional
    public Loja updatedLoja(Long id, Loja loja) {
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
    public void removeLoja(Loja loja) {
        this.lojaRepository.delete(loja);
    }
}
