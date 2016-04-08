package gapp.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="educationalbackgrounds")
public class EducationalBackground implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EducationalBackground() {
		super();
	}
	@Id
	@GeneratedValue
	private Integer eduId;
	
	private String degree;
	private String college;
	private Integer duration;
	private String major;
	@ManyToOne
	private Applications applicant;
	
	
	public Integer getEduId() {
		return eduId;
	}
	public void setEduId(Integer eduId) {
		this.eduId = eduId;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public Applications getApplicant() {
		return applicant;
	}
	public void setApplicant(Applications applicant) {
		this.applicant = applicant;
	}
}
