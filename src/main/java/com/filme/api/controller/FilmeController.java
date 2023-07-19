package com.filme.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.filme.api.domain.filme.DadosAuteraFilme;
import com.filme.api.domain.filme.DadosCadastroFilme;
import com.filme.api.domain.filme.Filme;
import com.filme.api.domain.filme.FilmeRepository;

import jakarta.transaction.Transactional;

@Controller
@RequestMapping("/filme")
public class FilmeController {

    @Autowired
    private FilmeRepository repository;

    @GetMapping
    public String carregarPaginaListagem(Model model) {
        model.addAttribute("lista", repository.findAll());
        return "filmes/listagem";
    }

    @GetMapping("/formulario")
    public String carregarPaginaFormulario(Long id, Model model) {
        if (id != null) {
            var filme = repository.getById(id);
            model.addAttribute("filme", filme);
        }
        return "filmes/formulario";
    }

    @PostMapping
    @Transactional
    public String cadastrar(DadosCadastroFilme dados) {
        var filme = new Filme(dados);
        repository.save(filme);
        return "redirect:/filme";
    }

    @PutMapping
    @Transactional
    public String alteraFilme(DadosAuteraFilme dados) {
        var filme = repository.getById(dados.id());
        filme.atualizarDados(dados);
        return "redirect:/filme";
    }

    @DeleteMapping
    @Transactional
    public String removeFilme(Long id) {
        repository.deleteById(id);
        ;
        return "redirect:/filme";
    }

}
