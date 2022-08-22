package br.com.stefanini.stefaninifood.repository;

import br.com.stefanini.stefaninifood.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
