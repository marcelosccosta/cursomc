package com.marcelocosta.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelocosta.cursomc.domain.Cliente;
import com.marcelocosta.cursomc.repositories.ClienteRepository;
import com.marcelocosta.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteSevice {
	
	@Autowired
	ClienteRepository categoriaRepository;
	public Cliente find(Integer id) {
		
	Optional<Cliente> obj = categoriaRepository.findById(id);		
	return obj.orElseThrow(() -> new ObjectNotFoundException(
			"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
		
	}

}
