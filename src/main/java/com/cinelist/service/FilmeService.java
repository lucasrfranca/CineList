package com.cinelist.service;

import com.cinelist.model.Filme;
import com.cinelist.model.Usuario;
import com.cinelist.repository.FilmeRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class FilmeService {
	
	@Autowired
    private FilmeRepository filmeRepository;
    
    public Filme cadastrar(Filme filme, Usuario usuarioLogado) throws IllegalArgumentException {
        
        String tituloNormalizado = filme.getTitulo().trim();
        
        Optional<Filme> filmeExistente = filmeRepository
                .findByTituloAndUsuarioId(tituloNormalizado, usuarioLogado.getId());
        
        if (filmeExistente.isPresent()) {
            throw new IllegalArgumentException("Você já possui o filme '" + tituloNormalizado + "' no seu acervo.");
        }
        
        filme.setUsuario(usuarioLogado); 
        filme.setTitulo(tituloNormalizado);
        
        return filmeRepository.save(filme);
    }
    
    @Transactional
    public Filme atualizar(Filme filme) {
        return filmeRepository.save(filme);
    }
    
    @Transactional
    public void excluir(Long id) {
        filmeRepository.deleteById(id);
    }

    public Filme buscarPorId(Long id) {
        return filmeRepository.findById(id).orElse(null); 
    }
}