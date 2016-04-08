package gapp.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gapp.model.Department;
import gapp.model.Program;
import gapp.model.dao.DepartmentDao;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {
	
	@PersistenceContext
    private EntityManager entityManager;

	@Override
	public List<Department> getallDepartments() {
		return entityManager.createQuery("from Department",Department.class).getResultList();
	}

	@Override
	public Department getDepartment(String name) {
		
		
		return entityManager.createQuery(" from Department where department= :dept", Department.class).setParameter("dept",name).getSingleResult();
	}

	@Override
	public Department getDepartmentById(int id) {
		// TODO Auto-generated method stub
		return entityManager.createQuery(" from Department where id= :id", Department.class).setParameter("id",id).getSingleResult();	
	}
	

	@Transactional
	@Override
	public Department saveDepartment(Department department) {
		return entityManager.merge(department);
	}

	@Transactional
	@Override
	public Program saveProgram(Program program) {
		// TODO Auto-generated method stub
		return entityManager.merge(program);
	}

	@Override
	public Program getProgrambyId(int id) {
		// TODO Auto-generated method stub
		return entityManager.createQuery(" from Program where id= :id", Program.class).setParameter("id",id).getSingleResult();
	}

	@Transactional
	@Override
	public void removeProgrambtId(Program program) {
		// TODO Auto-generated method stub
		entityManager.remove(program);
	}

	

}
