package com.devsuperior.dsvendas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dsvendas.dto.VendedorDTO;
import com.devsuperior.dsvendas.entities.Vendedor;
import com.devsuperior.dsvendas.repositories.VendedorRepository;

@Service
public class VendedorService {
	
	@Autowired
	private VendedorRepository repository;
	
	public List<VendedorDTO> findAll(){
		
		List<Vendedor> result = repository.findAll();
		return result.stream().map(x -> new VendedorDTO(x)).collect(Collectors.toList());
	}

}
