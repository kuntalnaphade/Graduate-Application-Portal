package gapp.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gapp.model.Department;
import gapp.model.Status;
import gapp.model.StatusAudit;
import gapp.model.Term;
import gapp.model.dao.StatusDao;
import gapp.model.dao.TermDao;

@Repository
public class StatusDaoImpl implements StatusDao {

	@PersistenceContext
    private EntityManager entityManager;

	@Override
	public List<Status> getallStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Status getStatusbyname(String status) {
		// TODO Auto-generated method stub
		return entityManager.createQuery(" from Status where value= :status", Status.class).setParameter("status",status).getSingleResult();
	}

	@Override
	public Status getStatusbyid(int id) {
		// TODO Auto-generated method stub
		return entityManager.createQuery(" from Status where statusid= :id", Status.class).setParameter("id",id).getSingleResult();
	}

	@Transactional
	@Override
	public StatusAudit saveStatus(StatusAudit audit) {
		// TODO Auto-generated method stub
		return entityManager.merge(audit);
	}
	
	

}
