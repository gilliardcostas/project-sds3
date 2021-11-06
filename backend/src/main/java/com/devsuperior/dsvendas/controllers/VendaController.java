package com.devsuperior.dsvendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsvendas.dto.VendaDTO;
import com.devsuperior.dsvendas.dto.VendaSucessoDTO;
import com.devsuperior.dsvendas.dto.VendasSomadasDTO;
import com.devsuperior.dsvendas.service.VendaService;

@RestController
@RequestMapping(value = "/vendas")
public class VendaController {

	@Autowired
	private VendaService service;
	
	@GetMapping
	public ResponseEntity<Page<VendaDTO>> findAll(Pageable pageable) {
		Page<VendaDTO> list = service.findAll(pageable);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "quantia-por-vendedor")
	public ResponseEntity<List<VendasSomadasDTO>> quantiaGroupByVendedor() {
		List<VendasSomadasDTO> list = service.quantiaGroupByVendedor();
		return ResponseEntity.ok(list);
	}

	@GetMapping(value = "sucesso-por-vendedor")
	public ResponseEntity<List<VendaSucessoDTO>> sucessoGroupByVendedor() {
		List<VendaSucessoDTO> list = service.sucessoGroupByVendedor();
		return ResponseEntity.ok(list);
	}

}
