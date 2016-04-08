package gapp.model.dao.jpa;

import gapp.model.EducationalBackground;
import gapp.model.Program;
import gapp.model.dao.EduBackgroundDao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class EduBackgroundDaoImpl implements EduBackgroundDao {

	@PersistenceContext
    private EntityManager entityManager;

	@Override
	public List<EducationalBackground> getalleduBackground() {
		return entityManager.createQuery("from EducationalBackground",EducationalBackground.class).getResultList();
		
	}

	@Override
	public EducationalBackground getEdubckgroundid(int eduid) {
		// TODO Auto-generated method stub
		return entityManager.createQuery(" from EducationalBackground where eduid= :id", EducationalBackground.class).setParameter("id",eduid).getSingleResult();
	}

	@Transactional
	@Override
	public EducationalBackground saveEduDetails(
			EducationalBackground educationalBackground) {
		// TODO Auto-generated method stub
		return entityManager.merge(educationalBackground);
	}
	
	@Transactional
	@Override
	public void removeeduBachgroundbyId(EducationalBackground edu) {
		// TODO Auto-generated method stub
		entityManager.remove(edu);
	}
	
}
