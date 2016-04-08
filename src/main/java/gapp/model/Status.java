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
@Table(name="statuses")
public class Status implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Status() {
		super();
	}

	@Id
	@GeneratedValue
	private Integer statusId;
	
	private String value;
	
	@OneToMany(mappedBy="status",cascade=CascadeType.ALL)
	List<Applications> lstappApplications;

	@OneToMany(mappedBy="newstatus",cascade=CascadeType.ALL)
	List<StatusAudit> lststatusaudit;


	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public List<Applications> getLstappApplications() {
		return lstappApplications;
	}

	public void setLstappApplications(List<Applications> lstappApplications) {
		this.lstappApplications = lstappApplications;
	}

}
