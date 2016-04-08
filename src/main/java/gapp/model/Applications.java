package gapp.model;


import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="applications")
public class Applications implements Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	Integer applicationId;
	
	@ManyToOne
	private User user;
	
	private String cin;
	
	private String phoneNumber;
	
	private String gender;
	
	private String dob;
	
	private String citizenship;
	
	//private String term;
	
	private Integer toeflscore;
	
	private Integer grescore;
	
	private Double gpa;
	
	private String transcript;
	
	private String firstname;
	
	private String lastname;
	
	private String emailid;
	
	public String getTranscript() {
		return transcript;
	}

	public void setTranscript(String transcript) {
		this.transcript = transcript;
	}

	private boolean international;
	
	@ManyToOne
	private Program program;
	
	@ManyToOne
	private Department dept;
	
	@OneToMany(mappedBy="applicant")
	List<EducationalBackground> lsteEducationalBackgrounds;
	
    @ManyToOne
	private Status status;
    
    
    @OneToMany(mappedBy="applicant")
    List<ApplicantAdditionalFieldValue> lstfieldvalues;
    
    private String comment;
    
   private Timestamp modifiedtime; 
   
  
@OneToMany(mappedBy="applicant")
   private List<StatusAudit> lststatusaudit;
   
   @ManyToOne
   private Term term;
   
	public Applications() {
		super();
	}

	

	public Integer getApplicationId() {
		return applicationId;
	}



	public void setApplicationId(Integer applicationId) {
		this.applicationId = applicationId;
	}



	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getCitizenship() {
		return citizenship;
	}

	public void setCitizenship(String citizenship) {
		this.citizenship = citizenship;
	}

	public Term getTerm() {
		return term;
	}

	public void setTerm(Term term) {
		this.term = term;
	}

	public Integer getToeflscore() {
		return toeflscore;
	}

	public void setToeflscore(Integer toeflscore) {
		this.toeflscore = toeflscore;
	}

	public Integer getGrescore() {
		return grescore;
	}

	public void setGrescore(Integer grescore) {
		this.grescore = grescore;
	}

	public Double getGpa() {
		return gpa;
	}

	public void setGpa(Double gpa) {
		this.gpa = gpa;
	}

	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public List<EducationalBackground> getLsteEducationalBackgrounds() {
		return lsteEducationalBackgrounds;
	}

	public void setLsteEducationalBackgrounds(
			List<EducationalBackground> lsteEducationalBackgrounds) {
		this.lsteEducationalBackgrounds = lsteEducationalBackgrounds;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
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


	public List<ApplicantAdditionalFieldValue> getLstfieldvalues() {
		return lstfieldvalues;
	}

	public void setLstfieldvalues(
			List<ApplicantAdditionalFieldValue> lstfieldvalues) {
		this.lstfieldvalues = lstfieldvalues;
	}

	public boolean isInternational() {
		return international;
	}

	public void setInternational(boolean international) {
		this.international = international;
	}

	public List<StatusAudit> getLststatusaudit() {
		return lststatusaudit;
	}

	public void setLststatusaudit(List<StatusAudit> lststatusaudit) {
		this.lststatusaudit = lststatusaudit;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	

}
