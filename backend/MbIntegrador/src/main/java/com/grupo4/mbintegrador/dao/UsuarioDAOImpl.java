package com.grupo4.mbintegrador.dao;

import com.grupo4.mbintegrador.model.Usuario;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

public class UsuarioDAOImpl implements UsuarioDAO {

    private final JdbcTemplate jdbcTemplate;

    public UsuarioDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // RowMapper personalizado para mapear filas de SQL a objetos Usuario
    private RowMapper<Usuario> usuarioRowMapper = new RowMapper<Usuario>() {
        @Override
        public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
            Usuario usuario = new Usuario();
            usuario.setIusuId(rs.getInt("iusu_id"));
            usuario.setVusuNomb(rs.getString("vusu_nomb"));
            usuario.setVusuApel(rs.getString("vusu_apel"));
            usuario.setVusuCorr(rs.getString("vusu_corr"));
            usuario.setVusuClav(rs.getString("vusu_clav"));
            usuario.setIusuTipo(rs.getInt("iusu_tipo"));
            usuario.setIusuEsta(rs.getInt("iusu_esta"));
            usuario.setDusuFecc(rs.getTimestamp("dusu_fecc"));
            usuario.setDusuFecm(rs.getTimestamp("dusu_fecm"));
            usuario.setVusuUsuc(rs.getString("vusu_usuc"));
            usuario.setVusuUsum(rs.getString("vusu_usum"));
            // Aquí podrías mapear la relación con perfil_usuario si lo necesitas
            return usuario;
        }
    };

    @Override
    public Usuario findById(int id) {
        String sql = "SELECT * FROM usuario WHERE iusu_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, usuarioRowMapper);
    }

    @Override
    public List<Usuario> findAll() {
        String sql = "SELECT * FROM usuario";
        return jdbcTemplate.query(sql, usuarioRowMapper);
    }

    @Override
    public void save(Usuario usuario) {
        String sql = "INSERT INTO usuario (vusu_nomb, vusu_apel, vusu_corr, vusu_clav, iusu_tipo, iusu_esta, dusu_fecc, dusu_fecm, vusu_usuc, vusu_usum, iperf_id) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, usuario.getVusuNomb(), usuario.getVusuApel(), usuario.getVusuCorr(), 
                            usuario.getVusuClav(), usuario.getIusuTipo(), usuario.getIusuEsta(), 
                            usuario.getDusuFecc(), usuario.getDusuFecm(), usuario.getVusuUsuc(), 
                            usuario.getVusuUsum(), usuario.getPerfilUsuario().getIperfId());
    }

    @Override
    public void update(Usuario usuario) {
        String sql = "UPDATE usuario SET vusu_nomb = ?, vusu_apel = ?, vusu_corr = ?, vusu_clav = ?, iusu_tipo = ?, iusu_esta = ?, dusu_fecm = ?, vusu_usum = ?, iperf_id = ? WHERE iusu_id = ?";
        jdbcTemplate.update(sql, usuario.getVusuNomb(), usuario.getVusuApel(), usuario.getVusuCorr(),
                            usuario.getVusuClav(), usuario.getIusuTipo(), usuario.getIusuEsta(), 
                            usuario.getDusuFecm(), usuario.getVusuUsum(), usuario.getPerfilUsuario().getIperfId(),
                            usuario.getIusuId());
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM usuario WHERE iusu_id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public Usuario findByEmail(String email) {
        String sql = "SELECT * FROM usuario WHERE vusu_corr = ?";
        List<Usuario> usuarios = jdbcTemplate.query(sql, new Object[]{email}, usuarioRowMapper);
        return usuarios.isEmpty() ? null : usuarios.get(0);
    }
}

