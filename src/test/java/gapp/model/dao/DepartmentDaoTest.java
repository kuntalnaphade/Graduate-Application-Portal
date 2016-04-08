package gapp.model.dao;

import gapp.model.Applications;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

@Test(groups = "DepartmentDaoTest")
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class DepartmentDaoTest extends
		AbstractTransactionalTestNGSpringContextTests {
	@Autowired
	DepartmentDao departmentDao;

	/*@Test
	public void getDepartments() {
		assert departmentDao.getallDepartments().size() == 2;
	}
*/
	/*@Test
	public void getDepartmentApplications() {
		List<Applications> lstapplications=new ArrayList<Applications>();
		for(Applications a:departmentDao.getDepartment("Accounting Department").getLstappApplications())
		{
			if(a.getTerm().getTermname().equalsIgnoreCase("Fall 2016"))
			{lstapplications.add(a);}
		}
		
		assert lstapplications.size()== 1;
	}*/

/*	@Test
	public void getDepartmentbyID() {
		assert departmentDao.getDepartmentById(1).getDepartment().equalsIgnoreCase("Accounting Department");
	}*/
}
