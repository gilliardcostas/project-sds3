package com.devsuperior.dsvendas.dto;

import java.io.Serializable;

import com.devsuperior.dsvendas.entities.Vendedor;

public class VendaSucessoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String nomeVendedor;
	private Long visitado;
	private Long promocoes;
	
	public VendaSucessoDTO() {}

	public VendaSucessoDTO(Vendedor vendedor, Long visitado, Long promocoes) {
		nomeVendedor = vendedor.getNome();
		this.visitado = visitado;
		this.promocoes = promocoes;
	}

	public String getNomeVendedor() {
		return nomeVendedor;
	}

	public void setNomeVendedor(String nomeVendedor) {
		this.nomeVendedor = nomeVendedor;
	}

	public Long getVisitado() {
		return visitado;
	}

	public void setVisitado(Long visitado) {
		this.visitado = visitado;
	}

	public Long getPromocoes() {
		return promocoes;
	}

	public void setPromocoes(Long promocoes) {
		this.promocoes = promocoes;
	}

	
}
