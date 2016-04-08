package gapp.model.dao;

import gapp.model.Department;
import gapp.model.Program;
import gapp.model.User;

import java.util.List;

public interface DepartmentDao {
	List<Department> getallDepartments();
	
	Department getDepartment(String name);
	
	Department getDepartmentById(int id);
	Department saveDepartment( Department department );
	Program saveProgram(Program program);
	
	Program getProgrambyId(int id);
	void removeProgrambtId(Program program);
	
}
