package spring.com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import spring.com.beans.Luong;

public class LuongDAO {
    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public int save(Luong l) {
        String sql = "INSERT INTO luong (luong_id, nhanvien_id, thang, nam, tong_gio_lam, luong_thang) VALUES (?, ?, ?, ?, ?, ?)";
        return template.update(sql, l.getLuongId(), l.getNhanvienId(), l.getThang(), l.getNam(), l.getTongGioLam(), l.getLuongThang());
    }

    public int update(Luong l) {
        String sql = "UPDATE luong SET nhanvien_id=?, thang=?, nam=?, tong_gio_lam=?, luong_thang=? WHERE luong_id=?";
        return template.update(sql, l.getNhanvienId(), l.getThang(), l.getNam(), l.getTongGioLam(), l.getLuongThang(), l.getLuongId());
    }

    public int delete(String id) {
        String sql = "DELETE FROM luong WHERE luong_id=?";
        return template.update(sql, id);
    }

    public Luong getById(String id) {
        String sql = "SELECT * FROM luong WHERE luong_id=?";
        return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Luong.class));
    }

    public List<Luong> getAll() {
        return template.query("SELECT * FROM luong", new RowMapper<Luong>() {
            @Override
			public Luong mapRow(ResultSet rs, int row) throws SQLException {
                Luong l = new Luong();
                l.setLuongId(rs.getString("luong_id"));
                l.setNhanvienId(rs.getString("nhanvien_id"));
                l.setThang(rs.getInt("thang"));
                l.setNam(rs.getInt("nam"));
                l.setTongGioLam(rs.getInt("tong_gio_lam"));
                l.setLuongThang(rs.getDouble("luong_thang"));
                return l;
            }
        });
    }
}
