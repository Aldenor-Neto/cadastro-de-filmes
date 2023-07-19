package com.filme.api.domain.filme;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "filmes")
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private int duracao;
    private int ano;
    private String genero;

    public Filme() {
    }

    public Filme(DadosCadastroFilme dados) {
        this.nome = dados.nome();
        this.duracao = dados.duracao();
        this.ano = dados.ano();
        this.genero = dados.genero();
    }

    public void atualizarDados(DadosAuteraFilme dados) {
        this.nome = dados.nome();
        this.duracao = dados.duracao();
        this.ano = dados.ano();
        this.genero = dados.genero();
    }

    @Override
    public String toString() {
        return "Filme [nome=" + nome + ", duracao=" + duracao + ", ano=" + ano + ", genero=" + genero + "]";
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getDuracao() {
        return duracao;
    }

    public int getAno() {
        return ano;
    }

    public String getGenero() {
        return genero;
    }

}
