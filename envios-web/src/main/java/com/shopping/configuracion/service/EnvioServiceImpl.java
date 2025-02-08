package com.shopping.configuracion.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.gson.Gson;
import com.shopping.configuracion.modelo.Envio;
import com.shopping.configuracion.repositorio.EnvioRepository;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Service
public class EnvioServiceImpl implements EnvioService {

    @Autowired
    private EnvioRepository envioRepository;

	ObjectMapper objectMapper = new ObjectMapper();

	
	@Override
	public ResponseEntity<String> obtenerTodos() {
		try {
			List<Envio> lst= envioRepository.findAll();
			if(!lst.isEmpty()) {
				objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
				objectMapper.registerModule(new JavaTimeModule());

	            String json = objectMapper.writeValueAsString(lst);
				return new ResponseEntity<String>(json, HttpStatus.OK);
			}else{
				return new ResponseEntity<String>("No hay envios.",
						HttpStatus.BAD_REQUEST);
			}	
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getMessage(),HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@Override
	public ResponseEntity<String> obtenerPorId(Integer id) {
		try {
			List<Envio> lst= envioRepository.findById(id).stream().toList();
			if(!lst.isEmpty()) {
				objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
				objectMapper.registerModule(new JavaTimeModule());

	            String json = objectMapper.writeValueAsString(lst);
				return new ResponseEntity<String>(json, HttpStatus.OK);
			}else{
				return new ResponseEntity<String>("No hay envios.",
						HttpStatus.BAD_REQUEST);
			}	
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getMessage(),HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@Override
	public ResponseEntity<String> obtenerPorEstado(Integer estado) {
		try {
			List<Envio> lst= envioRepository.findByEstado(estado);
			if(!lst.isEmpty()) {
				objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
				objectMapper.registerModule(new JavaTimeModule());

	            String json = objectMapper.writeValueAsString(lst);
				return new ResponseEntity<String>(json, HttpStatus.OK);
			}else{
				return new ResponseEntity<String>("No hay envios.",
						HttpStatus.BAD_REQUEST);
			}	
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getMessage(),HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@Override
	public ResponseEntity<String> actualizarEnvio(Integer id, Envio envioActualizado) {
	    try {
	        Optional<Envio> envioOptional = envioRepository.findById(id);
	        
	        if (envioOptional.isPresent()) {
	            Envio envio = envioOptional.get();
	            
	            // Actualizar los campos
	            envio.setEstado(envioActualizado.getEstado());
	            envio.setIdUsuarioAsignado(envioActualizado.getIdUsuarioAsignado());
	            envio.setFechaEntrega(envioActualizado.getFechaEntrega());
	            envio.setObservaciones(envioActualizado.getObservaciones());
	            
	            // Guardar la actualización en la BD
	            envioRepository.save(envio);

	            // Convertir a JSON
	            
	            objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
				objectMapper.registerModule(new JavaTimeModule());

	            String json = objectMapper.writeValueAsString(envio);
	           // String jsonResponse = new Gson().toJson(envio);

	            return new ResponseEntity<>(json, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>("No se encontró el envío con ID: " + id, HttpStatus.BAD_REQUEST);
	        }

	    } catch (Exception e) {
	        return new ResponseEntity<>("Error al actualizar el envío: " + (e.getCause() != null ? e.getCause().getMessage() : e.getMessage()), HttpStatus.NOT_ACCEPTABLE);
	    }
	}


	@Override
	public ResponseEntity<String> eliminarEnvio(Integer id) {
		try {
			 envioRepository.deleteById(id);
			
				return new ResponseEntity<String>(new Gson().toJson("Se elimino el envio con id: "+id), HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getMessage(),HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	
	 // Actualizar observación de un envío
    public ResponseEntity<String> actualizarObservacion(Integer id, String observacion) {
    	try {
    		 Optional<Envio> optionalEnvio = envioRepository.findById(id);
    	        if (optionalEnvio.isPresent()) {
    	            Envio envio = optionalEnvio.get();
    	            envio.setObservaciones(observacion);
    	            
    	            objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    				objectMapper.registerModule(new JavaTimeModule());

    	            String json = objectMapper.writeValueAsString(envioRepository.save(envio));
    	            
    	            return new ResponseEntity<>(json, HttpStatus.OK);

    	        }
	            return new ResponseEntity<>("Error actualizando el envio con ID: " + id, HttpStatus.BAD_REQUEST);
			
			
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getMessage(),HttpStatus.NOT_ACCEPTABLE);
		}
    	
    	
       
    }

	@Override
	public ResponseEntity<String> asignarEnvio(int idEnvio, String userId) {
		try {
   		 Optional<Envio> optionalEnvio = envioRepository.findById(idEnvio);
         if (optionalEnvio.isPresent()) {
             Envio envio = optionalEnvio.get();
             envio.setIdUsuarioAsignado(userId);
             envioRepository.save(envio);
             objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
				objectMapper.registerModule(new JavaTimeModule());

	            String json = objectMapper.writeValueAsString(true);
	            
   	            return new ResponseEntity<>(json, HttpStatus.OK);

   	        }
	            return new ResponseEntity<>("Error asignado envio", HttpStatus.BAD_REQUEST);
			
			
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getMessage(),HttpStatus.NOT_ACCEPTABLE);
		}
   	
	}
	
	
	@Override
	public ResponseEntity<String> cambiarEstadoEnvio(int idEnvio, int nuevoEstado) {
		try {
			 Optional<Envio> optionalEnvio = envioRepository.findById(idEnvio);
		        if (optionalEnvio.isPresent()) {
		            Envio envio = optionalEnvio.get();
		            envio.setEstado(nuevoEstado);
		            envioRepository.save(envio);
                objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
				objectMapper.registerModule(new JavaTimeModule());

	            String json = objectMapper.writeValueAsString(true);
	            
   	            return new ResponseEntity<>(json, HttpStatus.OK);

   	        }
	            return new ResponseEntity<>("Error actualizando estado al envio", HttpStatus.BAD_REQUEST);
			
			
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getMessage(),HttpStatus.NOT_ACCEPTABLE);
		}
   	
	}

   
}
