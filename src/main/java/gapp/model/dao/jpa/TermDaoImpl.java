package gapp.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import gapp.model.Department;
import gapp.model.Term;
import gapp.model.dao.TermDao;

@Repository
public class TermDaoImpl implements TermDao {

	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
	public List<Term> getallTerms() {
		// TODO Auto-generated method stub
		 return entityManager.createQuery("from Term",Term.class).getResultList();
	}

	@Override
	public Term getTermbyid(int termid) {
		// TODO Auto-generated method stub
		return entityManager.createQuery(" from Term where termid= :id", Term.class).setParameter("id",termid).getSingleResult();
	}

}
