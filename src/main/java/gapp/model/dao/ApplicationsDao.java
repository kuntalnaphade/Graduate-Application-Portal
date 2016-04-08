package gapp.model.dao;
import gapp.model.Applications;
import gapp.model.User;
public interface ApplicationsDao {

	User getApplicationsByEmail(String name);
	Applications saveApplication( Applications application);
	
	Applications getApplicationbyid(int id);

}
