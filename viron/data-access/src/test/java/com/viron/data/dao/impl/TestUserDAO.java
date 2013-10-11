/**
 * 
 */
package com.viron.data.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.viron.data.entity.User;

/**
 * @author zoran.talevski
 * 
 */
public class TestUserDAO {

	private UserDAO userDAO;
	private Integer id;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		userDAO = new UserDAO();
		id = createUser();
	}

	private Integer createUser() {
		User user = new User();
		user.setName("test");
		user.setSurname("owner");
		user.setAddress("address");
		user.setCity("city");

		userDAO.beginTransaction();
		userDAO.create(user);
		userDAO.commitTransaction();

		assertNotNull(userDAO.findByPrimaryKey(user.getId()));
		return user.getId();
	}

	@Test
	public void testUpdate() {

		User user = userDAO.findByPrimaryKey(id);
		user.setCity("newcity");

		userDAO.beginTransaction();
		userDAO.update(user);
		userDAO.commitTransaction();

		assertEquals("newcity", userDAO.findByPrimaryKey(id)
				.getCity());

	}

	private void deleteUser() {
		
		User owner = userDAO.findByPrimaryKey(id);

		userDAO.beginTransaction();
		userDAO.delete(owner);
		userDAO.commitTransaction();

		assertNull(userDAO.findByPrimaryKey(id));
	}

	@Test
	public void testFindAll() {
		List<User> allowners = userDAO.findAll();
		assertTrue(allowners.size() > 0);
	}

	@Test
	public void testFindAllLike() {
		User user = new User();
		user.setId(id);
		List<User> allowners = userDAO.findAllLike(user);
		assertTrue(allowners.size() > 0);
	}
	
	@After
	public void tearDown() {
		deleteUser();
	}
}
