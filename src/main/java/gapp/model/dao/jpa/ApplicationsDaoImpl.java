package gapp.model.dao.jpa;

import gapp.model.Applications;
import gapp.model.Department;
import gapp.model.User;
import gapp.model.dao.ApplicationsDao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ApplicationsDaoImpl implements ApplicationsDao {
	@PersistenceContext
	EntityManager entitymanager;
	
	@Override
	public User getApplicationsByEmail(String email)
	{
		List<User> lstUser=entitymanager.createQuery("from User where email_id= :email",User.class).setParameter("email", email).getResultList();
		if(!lstUser.isEmpty())	
		 return lstUser.get(0);
		else
		return null;
	}

	@Transactional
	@Override
	public Applications saveApplication(Applications application) {
		// TODO Auto-generated method stub
		return entitymanager.merge(application);
	}

	@Override
	public Applications getApplicationbyid(int id) {
		// TODO Auto-generated method stub
		return entitymanager.createQuery(" from Applications where applicationid= :id", Applications.class).setParameter("id",id).getSingleResult();
	}

	
	

}
