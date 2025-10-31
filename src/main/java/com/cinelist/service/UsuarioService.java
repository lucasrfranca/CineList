package com.cinelist.service;

import com.cinelist.model.Usuario;
import com.cinelist.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
	
	@Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario cadastrar(Usuario usuario) throws IllegalArgumentException {
        
        Optional<Usuario> usuarioExistente = usuarioRepository.findByEmail(usuario.getEmail());
        if (usuarioExistente.isPresent()) {
            throw new IllegalArgumentException("O e-mail '" + usuario.getEmail() + "' já está cadastrado.");
        }

        return usuarioRepository.save(usuario);
    }
    
    public Usuario logar(String email, String senha) {

        Optional<Usuario> usuarioOpt = usuarioRepository.findByEmail(email);

        if (usuarioOpt.isEmpty()) {
            return null; 
        }

        Usuario usuario = usuarioOpt.get();

        if (usuario.getSenha().equals(senha)) {
            return usuario;
        } else {
            return null;
        }
    }
}