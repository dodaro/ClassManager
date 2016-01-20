package it.unical.classmanager.test;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
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
import it.unical.classmanager.utils.DateTimeFactory;




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
			u.setUsername("user"+i);
			u.setPassword("userPass"+i);
			u.setConfirmPassword("userPass"+i);
			u.setFirstName("userName"+1);
			u.setHash(u.getPassword());
			u.setLastName("userLastName"+1);
			u.setRole("user");
			u.setEmail("userEmail@email.it");
			u.setSerialNumber(""+i);
			u.setBirthDate(DateTimeFactory.getRandomDateLessThanYear(
					Calendar.getInstance().get(Calendar.YEAR)-18).getTime());
			userDao.create(u);
		}
	}
	
	
	@Test  
	public void deleteAllUsers() {
		UserDAO userDao = ((UserDAO) context.getBean("userDao"));
		userDao.deleteAllUser();
		assertEquals(0, userDao.getAllUsers().size());
	}
	
	@Test 
	public void testNumberOfUsers() {
		int users = ((UserDAO) context.getBean("userDao")).getAllUsers().size();
		assertEquals(10, users);
	}
	
}
