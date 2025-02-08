package com.shopping.configuracion.controller;

import com.shopping.configuracion.modelo.Envio;
import com.shopping.configuracion.service.EnvioService;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/envios")
public class EnvioController {

    @Autowired
    private EnvioService envioService;

    // 📌 Obtener todos los envíos
    @GetMapping( produces = MediaType.APPLICATION_JSON_VALUE)    
    public ResponseEntity<String> obtenerTodos() {
        return envioService.obtenerTodos();
    }

    // 📌 Obtener un envío por ID
    @GetMapping(value= "/{id}", produces = MediaType.APPLICATION_JSON_VALUE) 
    public ResponseEntity<String> obtenerPorId(@PathVariable Integer id) {
        return envioService.obtenerPorId(id);
    }

    // 📌 Obtener envíos por estado
    @GetMapping(value= "/estado/{estado}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> obtenerPorEstado(@PathVariable Integer estado) {
        return envioService.obtenerPorEstado(estado);
    }

    // 📌 Actualizar un envío
    @PutMapping(value= "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> actualizarEnvio(@PathVariable Integer id, @RequestBody Envio envio) {
        return envioService.actualizarEnvio(id, envio);
    }

    // 📌 Eliminar un envío
    @DeleteMapping(value= "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> eliminarEnvio(@PathVariable Integer id) {
        return envioService.eliminarEnvio(id);
    }
    
    @PutMapping("/{id}/actualizar-observacion")
    public ResponseEntity<String> actualizarObservacion(@PathVariable Integer id, @RequestBody ObservacionDTO observacionDTO) {
        return envioService.actualizarObservacion(id, observacionDTO.getObservacion());
    }
    
    @PostMapping("/asignar/{idEnvio}/{userId}")
    public ResponseEntity<?> asignarEnvio(@PathVariable int idEnvio,@PathVariable String userId  ) {
        return envioService.asignarEnvio(idEnvio, userId);
    }

    @PutMapping("/cambiarEstado/{idEnvio}/{nuevoEstado}")
    public ResponseEntity<?> cambiarEstado(@PathVariable int idEnvio, @PathVariable int nuevoEstado) {
        return envioService.cambiarEstadoEnvio(idEnvio, nuevoEstado);
    }
}
