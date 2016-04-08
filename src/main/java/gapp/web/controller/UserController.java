package gapp.web.controller;


import gapp.model.dao.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

public class UserController {
	 @Autowired
	    private UserDao userDao;

	    @RequestMapping("/users.html")
	    public String users( ModelMap models )
	    {
	        //models.put( "users", userDao.getallDepartments() );
	        return "departments";
	    }


}
