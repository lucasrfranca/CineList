package com.cinelist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.cinelist.service.FilmeService;
import com.cinelist.model.Usuario;
import com.cinelist.repository.FilmeRepository;
import com.cinelist.model.Filme;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CinelistController {
	
	@Autowired
    private FilmeService filmeService;
	
	@Autowired
    private FilmeRepository filmeRepository;
    
	@GetMapping("/acervo")
    public String exibirAcervo(HttpSession session, RedirectAttributes redirectAttributes, Model model) {
        
        Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
        
        if (usuarioLogado == null) {
            redirectAttributes.addFlashAttribute("erroLogin", "Você precisa estar logado para acessar o acervo.");
            return "redirect:/login";
        }
        
        model.addAttribute("nomeUsuario", usuarioLogado.getNome());
        
        List<Filme> filmes = filmeRepository.findByUsuarioId(usuarioLogado.getId());
        
        model.addAttribute("filmes", filmes);
        
        return "acervo";
    }

	@PostMapping("/filme/salvar")
    public String salvarFilme(
            @ModelAttribute Filme filme,
            HttpSession session,
            RedirectAttributes redirectAttributes) {
        
        Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
        
        if (usuarioLogado == null) {
            redirectAttributes.addFlashAttribute("mensagemErro", "Sua sessão expirou. Faça login novamente.");
            return "redirect:/login";
        }
        
        boolean isEdicao = filme.getId() != null && filme.getId() > 0;
        
        try {
            Filme filmeSalvo;
            
            if (isEdicao) {
                filme.setUsuario(usuarioLogado); 
                
                filmeSalvo = filmeService.atualizar(filme);
                redirectAttributes.addFlashAttribute("mensagemSucesso", "Filme editado com sucesso!");
                
            } else {
                filmeSalvo = filmeService.cadastrar(filme, usuarioLogado);
                redirectAttributes.addFlashAttribute("mensagemSucesso", "Filme '" + filmeSalvo.getTitulo() + "' cadastrado com sucesso!");
            }
            
            return "redirect:/acervo"; 
            
        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("mensagemErro", e.getMessage());
            return "redirect:/acervo"; 
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensagemErro", "Erro ao salvar o filme: " + e.getMessage());
            return "redirect:/acervo"; 
        }
    }
	
	@GetMapping("/filme/excluir/{id}")
    public String excluirFilme(@PathVariable("id") Long id, RedirectAttributes attributes) {
        
        try {
            filmeService.excluir(id);
            
            attributes.addFlashAttribute("mensagemSucesso", "Filme excluído com sucesso!");
            
        } catch (Exception e) {
            attributes.addFlashAttribute("mensagemErro", "Erro ao excluir filme: " + e.getMessage());
        }
        return "redirect:/acervo"; 
    }
}