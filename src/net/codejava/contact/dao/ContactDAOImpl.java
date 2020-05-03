// http://localhost:8081/ContactManager_springmvc-jdbc_servlet_jsp_jstl_maven_junit/  

package net.codejava.contact.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import net.codejava.contact.model.Contact;

public class ContactDAOImpl implements ContactDAO {
	
	private JdbcTemplate jdbcTempl;   
	
	public ContactDAOImpl(DataSource ds) {
		this.jdbcTempl = new JdbcTemplate(ds); 
	}

	@Override
	public int save(Contact c) {
		String sql = "INSERT INTO Contact (name, email, address, phone) VALUES (?, ?, ?, ?)"; 
		return jdbcTempl.update(sql, c.getName(), c.getEmail(), c.getAddress(), c.getPhone());  
	}

	@Override
	public int update(Contact contact) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Integer id) {
		String sql = "DELETE FROM Contact WHERE contact_id=" + id; 
		return jdbcTempl.update(sql);
	}

	@Override
	public Contact get(Integer id) {
		String sql = "SELECT * FROM Contact WHERE contact_id=" + id; 
		
		ResultSetExtractor<Contact> extractor = new ResultSetExtractor<Contact>() {
			              
			@Override
			public Contact extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					String name = rs.getString("name");
					String email = rs.getString("email"); 
					String address = rs.getString("address"); 
					String phone = rs.getString("phone"); 
					
					return new Contact(name, email, address, phone); 
				}
				return null;
			}
		}; 
		
		return jdbcTempl.query(sql, extractor); 
	}

	@Override
	public List<Contact> list() {
		String sql = "SELECT * FROM Contact";
		
		RowMapper<Contact> rowMapper = new RowMapper<Contact>() {

			@Override
			public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
				Integer id = rs.getInt("contact_id");
				String name = rs.getString("name"); 
				String email = rs.getString("email"); 
				String address = rs.getString("address"); 
				String phone = rs.getString("phone"); 
				
				return new Contact(id, name, email, address, phone);
			}
									
		};
		
		return jdbcTempl.query(sql, rowMapper);
	}

}
