package com.grupo4.mbintegrador.dao;

import com.grupo4.mbintegrador.model.MenuWeb;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class MenuWebDAOImpl implements MenuWebDAO {

    private final JdbcTemplate jdbcTemplate;

    public MenuWebDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<MenuWeb> menuWebRowMapper = new RowMapper<MenuWeb>() {
        @Override
        public MenuWeb mapRow(ResultSet rs, int rowNum) throws SQLException {
            MenuWeb menuWeb = new MenuWeb();
            menuWeb.setImenuId(rs.getInt("imenu_id"));
            menuWeb.setVmenNomb(rs.getString("vmen_nomb"));
            menuWeb.setVmenIcon(rs.getString("vmen_icon"));
            menuWeb.setVmenEsta(rs.getInt("vmen_esta"));
            menuWeb.setVmenRefe(rs.getString("vmen_refe"));
            return menuWeb;
        }
    };

    @Override
    public MenuWeb findById(int id) {
        String sql = "SELECT * FROM menu_web WHERE imenu_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, menuWebRowMapper);
    }

    @Override
    public List<MenuWeb> findAll() {
        String sql = "SELECT * FROM menu_web";
        return jdbcTemplate.query(sql, menuWebRowMapper);
    }

    @Override
    public void save(MenuWeb menuWeb) {
        String sql = "INSERT INTO menu_web (vmen_nomb, vmen_icon, vmen_esta, vmen_refe) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, menuWeb.getVmenNomb(), menuWeb.getVmenIcon(), menuWeb.getVmenEsta(), menuWeb.getVmenRefe());
    }

    @Override
    public void update(MenuWeb menuWeb) {
        String sql = "UPDATE menu_web SET vmen_nomb = ?, vmen_icon = ?, vmen_esta = ?, vmen_refe = ? WHERE imenu_id = ?";
        jdbcTemplate.update(sql, menuWeb.getVmenNomb(), menuWeb.getVmenIcon(), menuWeb.getVmenEsta(), menuWeb.getVmenRefe(), menuWeb.getImenuId());
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM menu_web WHERE imenu_id = ?";
        jdbcTemplate.update(sql, id);
    }
}
