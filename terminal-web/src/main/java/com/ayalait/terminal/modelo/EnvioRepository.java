package com.ayalait.terminal.modelo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface EnvioRepository extends JpaRepository<Envio, Integer> {
	
	List<Envio> findByEstado(Integer estado);
}