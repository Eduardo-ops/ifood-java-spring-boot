package br.com.stefanini.stefaninifood.repository;

import br.com.stefanini.stefaninifood.model.Loja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LojaRepository extends JpaRepository<Loja, Long> {
}
