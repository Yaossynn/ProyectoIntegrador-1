package com.grupo4.mbintegrador.service;

import com.grupo4.mbintegrador.dao.MenuWebDAO;
import com.grupo4.mbintegrador.model.MenuWeb;
import java.util.List;

public class MenuWebService {
    private final MenuWebDAO menuWebDAO;

    public MenuWebService(MenuWebDAO menuWebDAO) {
        this.menuWebDAO = menuWebDAO;
    }

    public MenuWeb obtenerMenuWebPorId(int id) {
        return menuWebDAO.findById(id);
    }

    public List<MenuWeb> obtenerTodosLosMenus() {
        return menuWebDAO.findAll();
    }

    public void registrarMenuWeb(MenuWeb menuWeb) {
        menuWebDAO.save(menuWeb);
    }

    public void actualizarMenuWeb(MenuWeb menuWeb) {
        menuWebDAO.update(menuWeb);
    }

    public void eliminarMenuWeb(int id) {
        menuWebDAO.delete(id);
    }
}
