package springmvc.com.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;

import org.springframework.jdbc.core.BeanPropertyRowMapper;


import springmvc.com.beans.User;



public class Userdao {
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
	    this.template = template;
	}

	public int save(User u) {
		String sql = "INSERT INTO Users (UserName, Password, FullName, Email, Phone, Role, CreateAT) VALUES (?, ?, ?, ?, ?, ?, ?)";
		return template.update(sql, u.getUserName(), u.getPassword(), u.getFullName(), u.getEmail(), u.getPhone(), u.getRole(), u.getCreateAT());

		
	}

	public int update(User u) {
		String sql = "UPDATE Users SET UserName=?, FullName=?, Password=?, Email=?, Phone=?, Role=?, CreateAT=? WHERE id=?";
		return template.update(sql, u.getUserName(), u.getFullName(), u.getPassword(), u.getEmail(), u.getPhone(), u.getRole(), u.getCreateAT(), u.getUserId());

	}

	public int delete(int id) {
		String sql = "delete from Users where id=" + id + "";
		return template.update(sql);
	}

	public User getEmpById(int id) {
		String sql = "select * from Users where id=?";
		return template.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<User>(User.class));
	}
	public List<User> getEmployees(){  
	    return template.query("select * from Users",new RowMapper(){  
	        public User mapRow(ResultSet rs, int row) throws SQLException {  
	            User e=new User();  
	            e.setUserId(rs.getInt(1));  
	            e.setUserName(rs.getString(2));  
	            e.setPassword(rs.getString(3));  
	            e.setFullName(rs.getString(4));
	            e.setEmail(rs.getString(5));
	            e.setPhone(rs.getString(6)); 
	            e.setRole(rs.getInt(7)); 
	            e.setCreateAT(rs.getString(8));
	            return e;  
	        }  
	    });  
	} 
}