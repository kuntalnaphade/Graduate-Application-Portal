package gapp.model.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

@Test(groups = "UserDaoTest")
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserDaoTest extends AbstractTransactionalTestNGSpringContextTests {
	
	@Autowired
    UserDao userDao;

   
   @Test
   public void getUserTpes()
   {
	   assert userDao.getUserTpe("Students").getUserstypeId()== 3;   
   }

}
   