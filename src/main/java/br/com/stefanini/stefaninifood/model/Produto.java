package br.com.stefanini.stefaninifood.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "produto")
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;
    @Column(name = "valor")
    private float valor;
    @Column(name = "descricao")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "loja_id", referencedColumnName = "id")
    private Loja loja;

    public Produto() {

    }

    public Produto(String nome, float valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

//    Se atentar a esse método
//    public Loja getLoja() {
//        return loja;
//    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }
}
