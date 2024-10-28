package com.grupo4.mbintegrador.controller;

import com.grupo4.mbintegrador.model.MenuWeb;
import com.grupo4.mbintegrador.security.JwtUtil;
import com.grupo4.mbintegrador.service.MenuWebService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/menuweb")
public class MenuWebController {
    private final MenuWebService menuWebService;
    private final JwtUtil jwtUtil;

    public MenuWebController(MenuWebService menuWebService, JwtUtil jwtUtil) {
        this.menuWebService = menuWebService;
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
    public ResponseEntity<MenuWeb> obtenerMenuWeb(@PathVariable int id, HttpServletRequest request) {
        if (!validarToken(request)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        MenuWeb menuWeb = menuWebService.obtenerMenuWebPorId(id);
        return ResponseEntity.ok(menuWeb);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<MenuWeb>> obtenerTodosLosMenus(HttpServletRequest request) {
        if (!validarToken(request)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        List<MenuWeb> menus = menuWebService.obtenerTodosLosMenus();
        return ResponseEntity.ok(menus);
    }

    @PostMapping("/registrar")
    public ResponseEntity<Void> registrarMenuWeb(@RequestBody MenuWeb menuWeb, HttpServletRequest request) {
        if (!validarToken(request)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        menuWebService.registrarMenuWeb(menuWeb);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Void> actualizarMenuWeb(@PathVariable int id, @RequestBody MenuWeb menuWeb, HttpServletRequest request) {
        if (!validarToken(request)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        menuWeb.setImenuId(id);
        menuWebService.actualizarMenuWeb(menuWeb);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarMenuWeb(@PathVariable int id, HttpServletRequest request) {
        if (!validarToken(request)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        menuWebService.eliminarMenuWeb(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
