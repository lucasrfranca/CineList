package com.cinelist.projeto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CinelistController {

    @GetMapping("/cadastro")
    public String exibirFormularioCadastro() {
        return "cadastro-usuario"; 
    }
    
    @GetMapping("/login")
    public String exibirTelaLogin() {
        return "login";
    }
    
    @GetMapping("/acervo")
    public String exibirAcervo() {
        return "acervo";
    }
}