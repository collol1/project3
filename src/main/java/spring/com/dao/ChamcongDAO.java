package spring.com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import spring.com.beans.Chamcong;

public class ChamcongDAO {
    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public int save(Chamcong c) {
        String sql = "INSERT INTO chamcong (chamcong_id, nhanvien_id, ngay, so_gio_lam) VALUES (?, ?, ?, ?)";
        return template.update(sql, c.getChamcongId(), c.getNhanvienId(), c.getNgay(), c.getSoGioLam());
    }

    public int update(Chamcong c) {
        String sql = "UPDATE chamcong SET nhanvien_id=?, ngay=?, so_gio_lam=? WHERE chamcong_id=?";
        return template.update(sql, c.getNhanvienId(), c.getNgay(), c.getSoGioLam(), c.getChamcongId());
    }

    public int delete(String id) {
        String sql = "DELETE FROM chamcong WHERE chamcong_id=?";
        return template.update(sql, id);
    }

    public Chamcong getById(String id) {
        String sql = "SELECT * FROM chamcong WHERE chamcong_id=?";
        return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Chamcong.class));
    }

    public List<Chamcong> getAll() {
        return template.query("SELECT * FROM chamcong", new RowMapper<Chamcong>() {
            @Override
			public Chamcong mapRow(ResultSet rs, int row) throws SQLException {
                Chamcong c = new Chamcong();
                c.setChamcongId(rs.getString("chamcong_id"));
                c.setNhanvienId(rs.getString("nhanvien_id"));
                c.setNgay(rs.getDate("ngay").toLocalDate());
                c.setSoGioLam(rs.getInt("so_gio_lam"));
                return c;
            }
        });
    }
}
