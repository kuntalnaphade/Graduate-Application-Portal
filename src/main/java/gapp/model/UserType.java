package gapp.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="userstype")
public class UserType implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int userstypeId;
	public int getUserstypeId() {
		return userstypeId;
	}


	public void setUserstypeId(int userstypeId) {
		this.userstypeId = userstypeId;
	}

	private String type;
	
	@ManyToMany(mappedBy ="lstusertype",cascade=CascadeType.ALL)
	List<User> lstUsers;
	
	public UserType() {
		super();
	}

	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


	
}
