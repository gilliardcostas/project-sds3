package com.devsuperior.dsvendas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsvendas.dto.VendaDTO;
import com.devsuperior.dsvendas.dto.VendaSucessoDTO;
import com.devsuperior.dsvendas.dto.VendasSomadasDTO;
import com.devsuperior.dsvendas.entities.Venda;
import com.devsuperior.dsvendas.repositories.VendaRepository;
import com.devsuperior.dsvendas.repositories.VendedorRepository;

@Service
public class VendaService {
	
	@Autowired
	private VendaRepository repository;
	
	@Autowired
	private VendedorRepository vendedorRepository;

	@Transactional(readOnly = true)
	public Page<VendaDTO> findAll(Pageable pageable){
		vendedorRepository.findAll();
		Page<Venda> result = repository.findAll(pageable);
		return result.map(x -> new VendaDTO(x));
	}
	
	@Transactional(readOnly = true)
	public List<VendasSomadasDTO> quantiaGroupByVendedor(){
		return repository.quantiaGroupByVendedor();
		
	}

	@Transactional(readOnly = true)
	public List<VendaSucessoDTO> sucessoGroupByVendedor(){
		return repository.sucessoGroupByVendedor();
		
	}

}
