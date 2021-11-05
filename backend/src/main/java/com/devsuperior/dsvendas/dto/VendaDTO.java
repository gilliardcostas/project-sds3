package com.devsuperior.dsvendas.dto;

import java.time.LocalDate;

import com.devsuperior.dsvendas.entities.Venda;

public class VendaDTO {
	
	private Long id;
	private Integer visitado;
	private Integer promocoes; 
	private Double quantia;
	private LocalDate date;
	
	private VendedorDTO vendedor;
	
	public VendaDTO() {}

	public VendaDTO(Long id, Integer visitado, Integer promocoes, Double quantia, LocalDate date,
			VendedorDTO vendedor) {
		this.id = id;
		this.visitado = visitado;
		this.promocoes = promocoes;
		this.quantia = quantia;
		this.date = date;
		this.vendedor = vendedor;
	}
	
	public VendaDTO(Venda entity) {
		id = entity.getId();
		visitado = entity.getVisitado();
		promocoes = entity.getPromocoes();
		quantia = entity.getQuantia();
		date = entity.getDate();
		vendedor = new VendedorDTO(entity.getVendedor());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getVisitado() {
		return visitado;
	}

	public void setVisitado(Integer visitado) {
		this.visitado = visitado;
	}

	public Integer getPromocoes() {
		return promocoes;
	}

	public void setPromocoes(Integer promocoes) {
		this.promocoes = promocoes;
	}

	public Double getQuantia() {
		return quantia;
	}

	public void setQuantia(Double quantia) {
		this.quantia = quantia;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public VendedorDTO getVendedor() {
		return vendedor;
	}

	public void setVendedor(VendedorDTO vendedor) {
		this.vendedor = vendedor;
	}
	
	

}
