package com.shopping.configuracion.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.configuracion.modelo.Envio;

public interface EnvioRepository extends JpaRepository<Envio, Integer> {
	
	List<Envio> findByEstado(Integer estado);
}