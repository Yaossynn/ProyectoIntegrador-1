package com.grupo4.mbintegrador.dao;

import com.grupo4.mbintegrador.model.MenuWeb;
import com.grupo4.mbintegrador.model.PerfilPermiso;
import com.grupo4.mbintegrador.model.PerfilUsuario;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PerfilPermisoDAOImpl implements PerfilPermisoDAO {

    private final JdbcTemplate jdbcTemplate;

    public PerfilPermisoDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<PerfilPermiso> perfilPermisoRowMapper = new RowMapper<PerfilPermiso>() {
        @Override
        public PerfilPermiso mapRow(ResultSet rs, int rowNum) throws SQLException {
            PerfilPermiso perfilPermiso = new PerfilPermiso();
            perfilPermiso.setIpermId(rs.getInt("iperm_id"));

            // Mapeo del objeto MenuWeb
            MenuWeb menuWeb = new MenuWeb();
            menuWeb.setImenuId(rs.getInt("imenu_id"));
            perfilPermiso.setMenuWeb(menuWeb);

            // Mapeo del objeto PerfilUsuario
            PerfilUsuario perfilUsuario = new PerfilUsuario();
            perfilUsuario.setIperfId(rs.getInt("iperf_id"));
            perfilPermiso.setPerfilUsuario(perfilUsuario);

            return perfilPermiso;
        }
    };

    @Override
    public PerfilPermiso findById(int id) {
        String sql = "SELECT * FROM perfil_permiso WHERE iperm_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, perfilPermisoRowMapper);
    }

    @Override
    public List<PerfilPermiso> findAll() {
        String sql = "SELECT * FROM perfil_permiso";
        return jdbcTemplate.query(sql, perfilPermisoRowMapper);
    }

    @Override
    public void save(PerfilPermiso perfilPermiso) {
        String sql = "INSERT INTO perfil_permiso (imenu_id, iperf_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, 
                            perfilPermiso.getMenuWeb().getImenuId(), // Obtenemos el id de MenuWeb
                            perfilPermiso.getPerfilUsuario().getIperfId()); // Obtenemos el id de PerfilUsuario
    }

    @Override
    public void update(PerfilPermiso perfilPermiso) {
        String sql = "UPDATE perfil_permiso SET imenu_id = ?, iperf_id = ? WHERE iperm_id = ?";
        jdbcTemplate.update(sql, 
                            perfilPermiso.getMenuWeb().getImenuId(), // Obtenemos el id de MenuWeb
                            perfilPermiso.getPerfilUsuario().getIperfId(), // Obtenemos el id de PerfilUsuario
                            perfilPermiso.getIpermId());
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM perfil_permiso WHERE iperm_id = ?";
        jdbcTemplate.update(sql, id);
    }
}
