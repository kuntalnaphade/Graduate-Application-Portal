package gapp.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="departments")
public class Department implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Integer deptId;
	private String department;
	
	private boolean grerequired;
	
	@OneToMany(mappedBy="dept",cascade=CascadeType.ALL)
	List<AdditionalField> lstAdditionalFields; 
	
	@OneToMany(mappedBy="dept")
	List<Program>lstPrograms;
	
	@OneToMany(mappedBy="dept",cascade=CascadeType.ALL)
	List<Applications>lstappApplications;
	
	public Department() {
		super();
		
	}

	
	public Integer getDeptId() {
		return deptId;
	}


	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}


	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public List<AdditionalField> getLstAdditionalFields() {
		return lstAdditionalFields;
	}

	public void setLstAdditionalFields(List<AdditionalField> lstAdditionalFields) {
		this.lstAdditionalFields = lstAdditionalFields;
	}

	public List<Program> getLstPrograms() {
		return lstPrograms;
	}

	public void setLstPrograms(List<Program> lstPrograms) {
		this.lstPrograms = lstPrograms;
	}

	public List<Applications> getLstappApplications() {
		return lstappApplications;
	}

	public void setLstappApplications(List<Applications> lstappApplications) {
		this.lstappApplications = lstappApplications;
	}

	public boolean isGrerequired() {
		return grerequired;
	}

	public void setGrerequired(boolean grerequired) {
		this.grerequired = grerequired;
	}

	
	
}
