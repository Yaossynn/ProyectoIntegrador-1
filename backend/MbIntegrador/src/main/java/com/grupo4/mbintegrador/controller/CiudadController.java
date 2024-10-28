package com.grupo4.mbintegrador.controller;

import com.grupo4.mbintegrador.model.Ciudad;
import com.grupo4.mbintegrador.security.JwtUtil;
import com.grupo4.mbintegrador.service.CiudadService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/ciudad")
public class CiudadController {
    private final CiudadService ciudadService;
    private final JwtUtil jwtUtil;

    public CiudadController(CiudadService ciudadService, JwtUtil jwtUtil) {
        this.ciudadService = ciudadService;
        this.jwtUtil = jwtUtil;
    }

    // Método para validar el token JWT en cada petición
    private boolean validarToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);
            return jwtUtil.validarToken(token, jwtUtil.obtenerUsuario(token));
        }
        return false;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ciudad> obtenerCiudad(@PathVariable int id, HttpServletRequest request) {
        if (!validarToken(request)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        Ciudad ciudad = ciudadService.obtenerCiudadPorId(id);
        return ResponseEntity.ok(ciudad);
    }

    @GetMapping("/todas")
    public ResponseEntity<List<Ciudad>> obtenerTodasLasCiudades(HttpServletRequest request) {
        if (!validarToken(request)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        List<Ciudad> ciudades = ciudadService.obtenerTodasLasCiudades();
        return ResponseEntity.ok(ciudades);
    }

    @PostMapping("/registrar")
    public ResponseEntity<Void> registrarCiudad(@RequestBody Ciudad ciudad, HttpServletRequest request) {
        if (!validarToken(request)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        ciudadService.registrarCiudad(ciudad);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Void> actualizarCiudad(@PathVariable int id, @RequestBody Ciudad ciudad, HttpServletRequest request) {
        if (!validarToken(request)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        ciudad.setIciuId(id);
        ciudadService.actualizarCiudad(ciudad);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarCiudad(@PathVariable int id, HttpServletRequest request) {
        if (!validarToken(request)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        ciudadService.eliminarCiudad(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
