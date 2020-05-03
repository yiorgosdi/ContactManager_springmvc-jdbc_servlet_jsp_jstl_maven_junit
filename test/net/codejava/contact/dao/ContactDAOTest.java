package net.codejava.contact.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import net.codejava.contact.model.Contact;

class ContactDAOTest {
	private DriverManagerDataSource ds; 
	private ContactDAO dao; 

	@Test
	void testSave() {
		ds = new DriverManagerDataSource(); 
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/contactdb");
		ds.setUsername("root");
		ds.setPassword("");
		
		dao = new ContactDAOImpl(ds); 
		
		Contact contact = new Contact("george d.", "georged@gmail.com", "Athens, Greece", "14342"); 
		int result = dao.save(contact); 
		
		assertTrue(result > 0); 		
	}

	@Test
	void testUpdate() {
		Integer id = 0; 
		Contact contact = dao.get(id);
		
		if (contact != null) { 
			System.out.println(contact);
		}
		assertNotNull(contact); 
	}

	@Test
	void testDelete() {
		Integer id = 3; 
		int result = dao.delete(id); 
		
		assertTrue(result > 0);  
	}

	@Test
	void testGet() {
		fail("Not yet implemented");
	}

	@Test
	void testList() {
		List<Contact> listContacts = dao.list(); 
			
		for (Contact aContact : listContacts) {
			if (StringUtils.isNotBlank(aContact.toString())) {
			System.out.println(aContact);
			}
		}
		assertTrue(listContacts.isEmpty()); 
	}

}
