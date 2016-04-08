package gapp.model.dao;

import java.util.List;

import gapp.model.User;
import gapp.model.UserType;

public interface UserDao {
	User saveUser( User user );
	
	UserType getUserTpe(String type);
    List<User> getUserByEmail(String email);
}
