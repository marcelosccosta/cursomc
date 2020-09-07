package com.marcelocosta.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelocosta.cursomc.domain.Pedido;
import com.marcelocosta.cursomc.repositories.PedidoRepository;
import com.marcelocosta.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	PedidoRepository PedidoRepository;
	public Pedido find(Integer id) {
		
	Optional<Pedido> obj = PedidoRepository.findById(id);		
	return obj.orElseThrow(() -> new ObjectNotFoundException(
			"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
		
	}

}
