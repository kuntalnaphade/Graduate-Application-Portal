package gapp.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="applicationstatusaudit")
public class StatusAudit implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StatusAudit() {
		super();
	}

	@Id
	@GeneratedValue
	Integer statusauditId;
	
	@ManyToOne(cascade=CascadeType.ALL)
	Status oldstatus;
	
	@ManyToOne(cascade=CascadeType.ALL)
	Status newstatus;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="modifiedBy")
	User modifiedBy;
	
	@ManyToOne
	@JoinColumn(name="applicantId")
	Applications applicant;
	
	String comment;
	
	Timestamp modifiedtime;



	public Integer getStatusauditId() {
		return statusauditId;
	}

	public void setStatusauditId(Integer statusauditId) {
		this.statusauditId = statusauditId;
	}

	

	
	public Applications getApplicant() {
		return applicant;
	}

	public void setApplicant(Applications applicant) {
		this.applicant = applicant;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Timestamp getModifiedtime() {
		return modifiedtime;
	}

	public void setModifiedtime(Timestamp modifiedtime) {
		this.modifiedtime = modifiedtime;
	}

	public Status getOldstatus() {
		return oldstatus;
	}

	public void setOldstatus(Status oldstatus) {
		this.oldstatus = oldstatus;
	}

	public Status getNewstatus() {
		return newstatus;
	}

	public void setNewstatus(Status newstatus) {
		this.newstatus = newstatus;
	}

	public User getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(User modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
		
}
