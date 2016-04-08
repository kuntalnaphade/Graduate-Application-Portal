package gapp.model.dao;

import gapp.model.dao.jpa.ApplicationsDaoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

@Test(groups="ApplicationDaoTest")
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ApplicationDaoTest extends AbstractTransactionalTestNGSpringContextTests {
	/*@Autowired
	ApplicationsDaoImpl applicationDao;
	
	@Test
	public void getapplicationByName() {
		assert true||applicationDao.getApplicationsByEmail("student1@localhost.localdomain").getLstappliApplications().size() == 1;
	}
*/
}
