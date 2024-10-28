package com.grupo4.mbintegrador.controller;

import com.grupo4.mbintegrador.model.TarifaMovil;
import com.grupo4.mbintegrador.security.JwtUtil;
import com.grupo4.mbintegrador.service.TarifaMovilService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/tarifamovil")
public class TarifaMovilController {
    private final TarifaMovilService tarifaMovilService;
    private final JwtUtil jwtUtil;

    public TarifaMovilController(TarifaMovilService tarifaMovilService, JwtUtil jwtUtil) {
        this.tarifaMovilService = tarifaMovilService;
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
    public ResponseEntity<TarifaMovil> obtenerTarifaMovil(@PathVariable int id, HttpServletRequest request) {
        if (!validarToken(request)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        TarifaMovil tarifaMovil = tarifaMovilService.obtenerTarifaMovilPorId(id);
        return ResponseEntity.ok(tarifaMovil);
    }

    @GetMapping("/todas")
    public ResponseEntity<List<TarifaMovil>> obtenerTodasLasTarifas(HttpServletRequest request) {
        if (!validarToken(request)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        List<TarifaMovil> tarifas = tarifaMovilService.obtenerTodasLasTarifas();
        return ResponseEntity.ok(tarifas);
    }

    @PostMapping("/registrar")
    public ResponseEntity<Void> registrarTarifaMovil(@RequestBody TarifaMovil tarifaMovil, HttpServletRequest request) {
        if (!validarToken(request)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        tarifaMovilService.registrarTarifaMovil(tarifaMovil);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Void> actualizarTarifaMovil(@PathVariable int id, @RequestBody TarifaMovil tarifaMovil, HttpServletRequest request) {
        if (!validarToken(request)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        tarifaMovil.setItarId(id);
        tarifaMovilService.actualizarTarifaMovil(tarifaMovil);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarTarifaMovil(@PathVariable int id, HttpServletRequest request) {
        if (!validarToken(request)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        tarifaMovilService.eliminarTarifaMovil(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
