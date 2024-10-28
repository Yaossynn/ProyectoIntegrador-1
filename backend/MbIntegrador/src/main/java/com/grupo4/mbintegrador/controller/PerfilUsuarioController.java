package com.grupo4.mbintegrador.controller;

import com.grupo4.mbintegrador.model.PerfilUsuario;
import com.grupo4.mbintegrador.security.JwtUtil;
import com.grupo4.mbintegrador.service.PerfilUsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/perfilusuario")
public class PerfilUsuarioController {
    private final PerfilUsuarioService perfilUsuarioService;
    private final JwtUtil jwtUtil;

    public PerfilUsuarioController(PerfilUsuarioService perfilUsuarioService, JwtUtil jwtUtil) {
        this.perfilUsuarioService = perfilUsuarioService;
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
    public ResponseEntity<PerfilUsuario> obtenerPerfilUsuario(@PathVariable int id, HttpServletRequest request) {
        if (!validarToken(request)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        PerfilUsuario perfilUsuario = perfilUsuarioService.obtenerPerfilUsuarioPorId(id);
        return ResponseEntity.ok(perfilUsuario);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<PerfilUsuario>> obtenerTodosLosPerfiles(HttpServletRequest request) {
        if (!validarToken(request)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        List<PerfilUsuario> perfiles = perfilUsuarioService.obtenerTodosLosPerfiles();
        return ResponseEntity.ok(perfiles);
    }

    @PostMapping("/registrar")
    public ResponseEntity<Void> registrarPerfilUsuario(@RequestBody PerfilUsuario perfilUsuario, HttpServletRequest request) {
        if (!validarToken(request)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        perfilUsuarioService.registrarPerfilUsuario(perfilUsuario);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Void> actualizarPerfilUsuario(@PathVariable int id, @RequestBody PerfilUsuario perfilUsuario, HttpServletRequest request) {
        if (!validarToken(request)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        perfilUsuario.setIperfId(id);
        perfilUsuarioService.actualizarPerfilUsuario(perfilUsuario);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarPerfilUsuario(@PathVariable int id, HttpServletRequest request) {
        if (!validarToken(request)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        perfilUsuarioService.eliminarPerfilUsuario(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
