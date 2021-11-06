package com.devsuperior.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dsvendas.dto.VendaSucessoDTO;
import com.devsuperior.dsvendas.dto.VendasSomadasDTO;
import com.devsuperior.dsvendas.entities.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long> {
	
	@Query("SELECT new com.devsuperior.dsvendas.dto.VendasSomadasDTO(obj.vendedor, SUM(obj.quantia))"
			+ " FROM Venda As obj GROUP BY obj.vendedor ")
	List<VendasSomadasDTO> quantiaGroupByVendedor();
	
	@Query("SELECT new com.devsuperior.dsvendas.dto.VendaSucessoDTO(obj.vendedor, SUM(obj.visitado), SUM(obj.promocoes))"
			+ " FROM Venda As obj GROUP BY obj.vendedor ")
	List<VendaSucessoDTO> sucessoGroupByVendedor(); 

}
