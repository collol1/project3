package spring.com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import spring.com.beans.Sanpham;

public class SanphamDAO {
    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public int save(Sanpham s) {
        String sql = "INSERT INTO sanpham (sanpham_id, ten_san_pham, so_luong_ton, so_luong_ban, gia) VALUES (?, ?, ?, ?, ?)";
        return template.update(sql, s.getSanphamId(), s.getTenSanPham(), s.getSoLuongTon(), s.getSoLuongBan(), s.getGia());
    }

    public int update(Sanpham s) {
        String sql = "UPDATE sanpham SET ten_san_pham=?, so_luong_ton=?, so_luong_ban=?, gia=? WHERE sanpham_id=?";
        return template.update(sql, s.getTenSanPham(), s.getSoLuongTon(), s.getSoLuongBan(), s.getGia(), s.getSanphamId());
    }

    public int delete(String id) {
        String sql = "DELETE FROM sanpham WHERE sanpham_id=?";
        return template.update(sql, id);
    }

    public Sanpham getById(String id) {
        String sql = "SELECT * FROM sanpham WHERE sanpham_id=?";
        return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Sanpham.class));
    }

    public List<Sanpham> getAll() {
        return template.query("SELECT * FROM sanpham", new RowMapper<Sanpham>() {
            @Override
			public Sanpham mapRow(ResultSet rs, int row) throws SQLException {
                Sanpham s = new Sanpham();
                s.setSanphamId(rs.getString("sanpham_id"));
                s.setTenSanPham(rs.getString("ten_san_pham"));
                s.setSoLuongTon(rs.getInt("so_luong_ton"));
                s.setSoLuongBan(rs.getInt("so_luong_ban"));
                s.setGia(rs.getDouble("gia"));
                return s;
            }
        });
    }
}
