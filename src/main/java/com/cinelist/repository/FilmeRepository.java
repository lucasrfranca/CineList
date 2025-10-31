package com.cinelist.repository;

import com.cinelist.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface FilmeRepository extends JpaRepository<Filme, Long> {
	
	List<Filme> findByUsuarioId(Long usuarioId);
	
	Optional<Filme> findByTituloAndUsuarioId(String titulo, Long usuarioId);
}
