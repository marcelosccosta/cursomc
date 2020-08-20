package com.marcelocosta.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelocosta.cursomc.domain.Categoria;
import com.marcelocosta.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaSevice {
	
	@Autowired
	CategoriaRepository categoriaRepository;
	public Categoria buscar(Integer id) {
		
	Optional<Categoria> obj = categoriaRepository.findById(id);		
	return obj.orElse(null);	
		
	}

}
