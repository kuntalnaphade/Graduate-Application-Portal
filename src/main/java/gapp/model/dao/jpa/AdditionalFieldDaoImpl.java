package gapp.model.dao.jpa;

import gapp.model.AdditionalField;
import gapp.model.ApplicantAdditionalFieldValue;
import gapp.model.Department;
import gapp.model.User;
import gapp.model.UserType;
import gapp.model.dao.AdditionalFiledDao;
import gapp.model.dao.ApplicationsDao;
import gapp.model.dao.UserDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public class AdditionalFieldDaoImpl implements AdditionalFiledDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
	@Override
	public AdditionalField savefield(AdditionalField additionalfield) {
		// TODO Auto-generated method stub
		return entityManager.merge(additionalfield);
	}

	@Override
	public AdditionalField getfieldbyId(int id) {
		// TODO Auto-generated method stub
		return entityManager.createQuery(" from AdditionalField where id= :id", AdditionalField.class).setParameter("id",id).getSingleResult();
	}

	@Transactional
	@Override
	public void removeAdditionalField(AdditionalField additionalfield) {
		// TODO Auto-generated method stub
		entityManager.remove(additionalfield);
	}

	@Transactional
	@Override
	public ApplicantAdditionalFieldValue saveVAlue(
			ApplicantAdditionalFieldValue value) {
		return entityManager.merge(value);
	}

	
       

}