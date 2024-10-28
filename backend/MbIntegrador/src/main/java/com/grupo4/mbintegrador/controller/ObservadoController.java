package com.grupo4.mbintegrador.controller;

import com.grupo4.mbintegrador.model.Observado;
import com.grupo4.mbintegrador.security.JwtUtil;
import com.grupo4.mbintegrador.service.ObservadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/observado")
public class ObservadoController {
    private final ObservadoService observadoService;
    private final JwtUtil jwtUtil;

    public ObservadoController(ObservadoService observadoService, JwtUtil jwtUtil) {
        this.observadoService = observadoService;
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
    public ResponseEntity<Observado> obtenerObservado(@PathVariable int id, HttpServletRequest request) {
        if (!validarToken(request)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        Observado observado = observadoService.obtenerObservadoPorId(id);
        return ResponseEntity.ok(observado);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Observado>> obtenerTodosLosObservados(HttpServletRequest request) {
        if (!validarToken(request)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        List<Observado> observados = observadoService.obtenerTodosLosObservados();
        return ResponseEntity.ok(observados);
    }

    @PostMapping("/registrar")
    public ResponseEntity<Void> registrarObservado(@RequestBody Observado observado, HttpServletRequest request) {
        if (!validarToken(request)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        observadoService.registrarObservado(observado);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Void> actualizarObservado(@PathVariable int id, @RequestBody Observado observado, HttpServletRequest request) {
        if (!validarToken(request)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        observado.setIobsId(id);
        observadoService.actualizarObservado(observado);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarObservado(@PathVariable int id, HttpServletRequest request) {
        if (!validarToken(request)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        observadoService.eliminarObservado(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
