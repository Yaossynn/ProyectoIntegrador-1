package com.grupo4.mbintegrador.controller;

import com.grupo4.mbintegrador.model.Parametro;
import com.grupo4.mbintegrador.security.JwtUtil;
import com.grupo4.mbintegrador.service.ParametroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/parametro")
public class ParametroController {
    private final ParametroService parametroService;
    private final JwtUtil jwtUtil;
    
    public ParametroController(ParametroService parametroService, JwtUtil jwtUtil) {
        this.parametroService = parametroService;
        this.jwtUtil = jwtUtil;
    }
    private boolean validarToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);
            return jwtUtil.validarToken(token, jwtUtil.obtenerUsuario(token));
        }
        return false;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Parametro> obtenerParametro(@PathVariable int id, HttpServletRequest request) {
        if (!validarToken(request)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        Parametro parametro = parametroService.obtenerParametroPorId(id);
        return ResponseEntity.ok(parametro);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Parametro>> obtenerTodosLosParametros(HttpServletRequest request) {
        if (!validarToken(request)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        List<Parametro> parametros = parametroService.obtenerTodosLosParametros();
        return ResponseEntity.ok(parametros);
    }

    @PostMapping("/registrar")
    public ResponseEntity<Void> registrarParametro(@RequestBody Parametro parametro, HttpServletRequest request) {
        if (!validarToken(request)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        parametroService.registrarParametro(parametro);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Void> actualizarParametro(@PathVariable int id, @RequestBody Parametro parametro, HttpServletRequest request) {
        if (!validarToken(request)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        parametro.setIparamId(id);
        parametroService.actualizarParametro(parametro);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarParametro(@PathVariable int id, HttpServletRequest request) {
        if (!validarToken(request)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        parametroService.eliminarParametro(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
