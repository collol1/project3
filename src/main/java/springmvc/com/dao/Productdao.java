package springmvc.com.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import springmvc.com.beans.Product;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Productdao {
    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public int save(Product p) {
        String sql = "INSERT INTO Products (ProductName, Description, Price, ImageURL, CreateAt, UpdateAt) VALUES (?, ?, ?, ?, ?, ?)";
        return template.update(sql, p.getProductName(), p.getDescription(), p.getPrice(), p.getImageURL(), p.getCreateAt(), p.getUpdateAt());
    }

    public int update(Product p) {
        String sql = "UPDATE Products SET ProductName=?, Description=?, Price=?, ImageURL=?, CreateAt=?, UpdateAt=? WHERE ProductId=?";
        return template.update(sql, p.getProductName(), p.getDescription(), p.getPrice(), p.getImageURL(), p.getCreateAt(), p.getUpdateAt(), p.getProductId());
    }

    public int delete(int id) {
        String sql = "DELETE FROM Products WHERE ProductId=?";
        return template.update(sql, id);
    }

    public Product getProductById(int id) {
        String sql = "SELECT * FROM Products WHERE ProductId=?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<>(Product.class), id);
    }

    public List<Product> getProducts() {
        String sql = "SELECT * FROM Products";
        return template.query(sql, new RowMapper<Product>() {
            public Product mapRow(ResultSet rs, int row) throws SQLException {
                Product o = new Product();
                o.setProductId(rs.getInt("ProductId"));
                o.setProductName(rs.getString("ProductName"));
                o.setDescription(rs.getString("Description"));
                o.setPrice(rs.getDouble("Price"));
                o.setImageURL(rs.getString("ImageURL"));
                o.setCreateAt(rs.getTimestamp("CreateAt"));
                o.setUpdateAt(rs.getTimestamp("UpdateAt"));
                return o;
            }
        });
    }
}
