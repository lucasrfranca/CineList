package com.cinelist.controller;

import com.cinelist.model.Usuario;
import com.cinelist.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {
	
	@Autowired
    private UsuarioService usuarioService;

    @GetMapping("/login")
    public String exibirTelaLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String processarLogin(

            @RequestParam String email, 
            @RequestParam String senha,
            HttpSession session,
            RedirectAttributes redirectAttributes) {

        Usuario usuarioLogado = usuarioService.logar(email, senha);

        if (usuarioLogado != null) {
            session.setAttribute("usuarioLogado", usuarioLogado);
            
            return "redirect:/acervo";

        } else {
            redirectAttributes.addFlashAttribute("erroLogin", "E-mail ou senha incorretos.");
            
            return "redirect:/login"; 
        }
    }
    
    @GetMapping("/logout")
    public String deslogar(HttpSession session, RedirectAttributes redirectAttributes) {
        
        session.invalidate();
        
        redirectAttributes.addFlashAttribute("sucesso", "Você foi desconectado com sucesso.");
       
        return "redirect:/login";
    }
}
