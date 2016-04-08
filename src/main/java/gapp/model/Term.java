package gapp.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="terms")
public class Term {
	
	@Id
	@GeneratedValue
	Integer termId;
	String termname;
	
	@OneToMany(mappedBy="term",cascade=CascadeType.ALL)
	List<Applications> lstApplications;

	

	public Integer getTermId() {
		return termId;
	}

	public void setTermId(Integer termId) {
		this.termId = termId;
	}

	public String getTermname() {
		return termname;
	}

	public void setTermname(String termname) {
		this.termname = termname;
	}

	public List<Applications> getLstApplications() {
		return lstApplications;
	}

	public void setLstApplications(List<Applications> lstApplications) {
		this.lstApplications = lstApplications;
	}

}
