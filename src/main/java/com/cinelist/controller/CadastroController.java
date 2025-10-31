package com.cinelist.controller;

import com.cinelist.model.Usuario;
import com.cinelist.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CadastroController {

	@Autowired
    private UsuarioService usuarioService;

    @GetMapping("/cadastro")
    public String exibirFormulario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "cadastro-usuario"; 
    }

    @PostMapping("/cadastro")
    public String cadastrarUsuario(
            @ModelAttribute("usuario") Usuario usuario,
            RedirectAttributes redirectAttributes,
            String confirmarSenha 
    ) {

        if (!usuario.getSenha().equals(confirmarSenha)) {
            redirectAttributes.addFlashAttribute("erro", "As senhas digitadas não coincidem.");
            return "redirect:/cadastro"; 
        }
        
        try {
            usuarioService.cadastrar(usuario);

            redirectAttributes.addFlashAttribute("sucesso", "Cadastro realizado com sucesso!");
            return "redirect:/login";

        } catch (IllegalArgumentException e) {
            
            redirectAttributes.addFlashAttribute("erro", e.getMessage());
            return "redirect:/cadastro";
        }
    }
}