package gapp.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="programs")
public class Program implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Program() {
		super();
	}

	@Id
	@GeneratedValue
	private Integer programId;
	
	private String program;
	
	@JsonIgnore
	@ManyToOne
	private Department dept;
	
	@JsonIgnore
	@OneToMany(mappedBy="program")
	List<Applications> lstApplications;

	

	public Integer getProgramId() {
		return programId;
	}

	public void setProgramId(Integer programId) {
		this.programId = programId;
	}

	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public List<Applications> getLstApplications() {
		return lstApplications;
	}

	public void setLstApplications(List<Applications> lstApplications) {
		this.lstApplications = lstApplications;
	}
	
}
