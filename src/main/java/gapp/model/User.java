package gapp.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer userId;
	
	private String first_name;
	
	private String last_name;
	

	private String email_id;

	private String password;

	
	
	
	@ManyToMany
	List<UserType> lstusertype;
	
	@OneToMany(mappedBy="user")
	List<Applications> lstappliApplications;

	public User() {
	}

	

	public Integer getUserId() {
		return userId;
	}



	public void setUserId(Integer userId) {
		this.userId = userId;
	}



	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<UserType> getLstusertype() {
		return lstusertype;
	}

	public void setLstusertype(List<UserType> lstusertype) {
		this.lstusertype = lstusertype;
	}

	public List<Applications> getLstappliApplications() {
		return lstappliApplications;
	}

	public void setLstappliApplications(List<Applications> lstappliApplications) {
		this.lstappliApplications = lstappliApplications;
	}


}
