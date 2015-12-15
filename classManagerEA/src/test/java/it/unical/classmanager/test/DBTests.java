package it.unical.classmanager.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import it.unical.classmanager.model.dao.UserDAO;
import it.unical.classmanager.model.data.User;



@TestExecutionListeners( { DependencyInjectionTestExecutionListener.class })
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:**/WEB-INF/spring/root-context.xml"})
public class DBTests{

	@Autowired
	private ApplicationContext context;	
	
	@Before
	public void init() {
		UserDAO userDao  = (UserDAO) context.getBean("userDao");
		for ( int i = 0 ; i < 10 ; i++ ) {
			User u = new User();
			u.setUsername("user "+i);
			u.setPassword("userPass "+i);
			u.setFirstName("userName "+1);
			u.setLastName("userLastName "+1);
			u.setRole("user");
			u.setEmail("userEmail@email.it");
			u.setAddress("");
			u.setBirthDate(new Date());
			userDao.create(u);
		}
	}
	
	@After
	public void delete() {
		//((UserDAO) context.getBean("userDao")).deleteAllUser();
	}
	
	@Test
	public void testNumberOfUsers() {
		int users = ((UserDAO) context.getBean("userDao")).getAllUsers().size();
		assertEquals(10, users);
	}
	
}
