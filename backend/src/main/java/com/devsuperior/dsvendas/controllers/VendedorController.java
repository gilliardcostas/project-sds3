package com.devsuperior.dsvendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsvendas.dto.VendedorDTO;
import com.devsuperior.dsvendas.service.VendedorService;

@RestController
@RequestMapping(value = "/vendedores")
public class VendedorController {

	@Autowired
	private VendedorService service;
	
	@GetMapping
	public ResponseEntity<List<VendedorDTO>> findAll() {
		List<VendedorDTO> list = service.findAll();
		return ResponseEntity.ok(list);
	}
}
