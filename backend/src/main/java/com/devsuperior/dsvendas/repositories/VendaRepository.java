package com.devsuperior.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsvendas.entities.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long> {

}
