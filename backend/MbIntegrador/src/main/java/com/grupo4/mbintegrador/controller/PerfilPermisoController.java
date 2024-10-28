package com.grupo4.mbintegrador.controller;

import com.grupo4.mbintegrador.model.PerfilPermiso;
import com.grupo4.mbintegrador.security.JwtUtil;
import com.grupo4.mbintegrador.service.PerfilPermisoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/perfilpermiso")
public class PerfilPermisoController {
    private final PerfilPermisoService perfilPermisoService;
    private final JwtUtil jwtUtil;

    public PerfilPermisoController(PerfilPermisoService perfilPermisoService, JwtUtil jwtUtil) {
        this.perfilPermisoService = perfilPermisoService;
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
    public ResponseEntity<PerfilPermiso> obtenerPerfilPermiso(@PathVariable int id, HttpServletRequest request) {
        if (!validarToken(request)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        PerfilPermiso perfilPermiso = perfilPermisoService.obtenerPerfilPermisoPorId(id);
        return ResponseEntity.ok(perfilPermiso);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<PerfilPermiso>> obtenerTodosLosPermisos(HttpServletRequest request) {
        if (!validarToken(request)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        List<PerfilPermiso> permisos = perfilPermisoService.obtenerTodosLosPermisos();
        return ResponseEntity.ok(permisos);
    }

    @PostMapping("/registrar")
    public ResponseEntity<Void> registrarPerfilPermiso(@RequestBody PerfilPermiso perfilPermiso, HttpServletRequest request) {
        if (!validarToken(request)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        perfilPermisoService.registrarPerfilPermiso(perfilPermiso);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Void> actualizarPerfilPermiso(@PathVariable int id, @RequestBody PerfilPermiso perfilPermiso, HttpServletRequest request) {
        if (!validarToken(request)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        perfilPermiso.setIpermId(id);
        perfilPermisoService.actualizarPerfilPermiso(perfilPermiso);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarPerfilPermiso(@PathVariable int id, HttpServletRequest request) {
        if (!validarToken(request)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        perfilPermisoService.eliminarPerfilPermiso(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
