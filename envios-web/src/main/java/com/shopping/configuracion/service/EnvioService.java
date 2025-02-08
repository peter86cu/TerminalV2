package com.shopping.configuracion.service;



import org.springframework.http.ResponseEntity;

import com.shopping.configuracion.modelo.Envio;

public interface EnvioService {
	ResponseEntity<String> obtenerTodos();

	ResponseEntity<String> obtenerPorId(Integer id);

	ResponseEntity<String> obtenerPorEstado(Integer estado);

	ResponseEntity<String> actualizarEnvio(Integer id, Envio envioActualizado);

	ResponseEntity<String> eliminarEnvio(Integer id);
	
	ResponseEntity<String> actualizarObservacion(Integer id, String observacion);
	
	ResponseEntity<String> asignarEnvio(int idEnvio, String userId);
	
	ResponseEntity<String>  cambiarEstadoEnvio(int idEnvio, int nuevoEstado);
}

