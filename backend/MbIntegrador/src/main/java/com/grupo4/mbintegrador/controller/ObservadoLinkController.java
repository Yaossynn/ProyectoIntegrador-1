package com.grupo4.mbintegrador.controller;

import com.grupo4.mbintegrador.model.ObservadoLink;
import com.grupo4.mbintegrador.security.JwtUtil;
import com.grupo4.mbintegrador.service.ObservadoLinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/observadolink")
public class ObservadoLinkController {
    private final ObservadoLinkService observadoLinkService;
    private final JwtUtil jwtUtil;

    public ObservadoLinkController(ObservadoLinkService observadoLinkService, JwtUtil jwtUtil) {
        this.observadoLinkService = observadoLinkService;
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
    public ResponseEntity<ObservadoLink> obtenerObservadoLink(@PathVariable int id, HttpServletRequest request) {
        if (!validarToken(request)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        ObservadoLink observadoLink = observadoLinkService.obtenerObservadoLinkPorId(id);
        return ResponseEntity.ok(observadoLink);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<ObservadoLink>> obtenerTodosLosObservadoLinks(HttpServletRequest request) {
        if (!validarToken(request)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        List<ObservadoLink> observadoLinks = observadoLinkService.obtenerTodosLosObservadoLinks();
        return ResponseEntity.ok(observadoLinks);
    }

    @PostMapping("/registrar")
    public ResponseEntity<Void> registrarObservadoLink(@RequestBody ObservadoLink observadoLink, HttpServletRequest request) {
        if (!validarToken(request)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        observadoLinkService.registrarObservadoLink(observadoLink);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Void> actualizarObservadoLink(@PathVariable int id, @RequestBody ObservadoLink observadoLink, HttpServletRequest request) {
        if (!validarToken(request)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        observadoLink.setIolinId(id);
        observadoLinkService.actualizarObservadoLink(observadoLink);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarObservadoLink(@PathVariable int id, HttpServletRequest request) {
        if (!validarToken(request)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        observadoLinkService.eliminarObservadoLink(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
