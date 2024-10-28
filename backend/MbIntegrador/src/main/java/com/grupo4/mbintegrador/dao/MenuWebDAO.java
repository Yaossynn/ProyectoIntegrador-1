package com.grupo4.mbintegrador.dao;

import com.grupo4.mbintegrador.model.MenuWeb;
import java.util.List;

public interface MenuWebDAO {
    MenuWeb findById(int id);
    List<MenuWeb> findAll();
    void save(MenuWeb menuWeb);
    void update(MenuWeb menuWeb);
    void delete(int id);
}
