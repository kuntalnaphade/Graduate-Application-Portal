package gapp.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="applicantadditonalfieldvalues")

public class ApplicantAdditionalFieldValue {
	public ApplicantAdditionalFieldValue() {
		super();
	}

	@Id
	@GeneratedValue
	private Integer fieldValueId;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="applicant_id")
	Applications applicant;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="additionalfield_id")
	AdditionalField field;	
	
	String value;

	

	public Integer getFieldValueId() {
		return fieldValueId;
	}

	public void setFieldValueId(Integer fieldValueId) {
		this.fieldValueId = fieldValueId;
	}

	public Applications getApplicant() {
		return applicant;
	}

	public void setApplicant(Applications applicant) {
		this.applicant = applicant;
	}

	public AdditionalField getField() {
		return field;
	}

	public void setField(AdditionalField field) {
		this.field = field;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	} 

}
