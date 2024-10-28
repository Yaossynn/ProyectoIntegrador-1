package com.grupo4.mbintegrador.dao;

import com.grupo4.mbintegrador.model.PerfilUsuario;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PerfilUsuarioDAOImpl implements PerfilUsuarioDAO {

    private final JdbcTemplate jdbcTemplate;

    public PerfilUsuarioDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<PerfilUsuario> perfilUsuarioRowMapper = new RowMapper<PerfilUsuario>() {
        @Override
        public PerfilUsuario mapRow(ResultSet rs, int rowNum) throws SQLException {
            PerfilUsuario perfilUsuario = new PerfilUsuario();
            perfilUsuario.setIperfId(rs.getInt("iperf_id"));
            perfilUsuario.setVperfNomb(rs.getString("vperf_nomb"));
            perfilUsuario.setIperfEsta(rs.getInt("iperf_esta"));
            return perfilUsuario;
        }
    };

    @Override
    public PerfilUsuario findById(int id) {
        String sql = "SELECT * FROM perfil_usuario WHERE iperf_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, perfilUsuarioRowMapper);
    }

    @Override
    public List<PerfilUsuario> findAll() {
        String sql = "SELECT * FROM perfil_usuario";
        return jdbcTemplate.query(sql, perfilUsuarioRowMapper);
    }

    @Override
    public void save(PerfilUsuario perfilUsuario) {
        String sql = "INSERT INTO perfil_usuario (vperf_nomb, iperf_esta) VALUES (?, ?)";
        jdbcTemplate.update(sql, perfilUsuario.getVperfNomb(), perfilUsuario.getIperfEsta());
    }

    @Override
    public void update(PerfilUsuario perfilUsuario) {
        String sql = "UPDATE perfil_usuario SET vperf_nomb = ?, iperf_esta = ? WHERE iperf_id = ?";
        jdbcTemplate.update(sql, perfilUsuario.getVperfNomb(), perfilUsuario.getIperfEsta(), perfilUsuario.getIperfId());
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM perfil_usuario WHERE iperf_id = ?";
        jdbcTemplate.update(sql, id);
    }
}
