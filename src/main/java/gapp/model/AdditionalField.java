package gapp.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="additionalfields")
public class AdditionalField implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public AdditionalField() {
		super();
	}
	@Id
	@GeneratedValue
	Integer fieldId;
	String name;
	String fieldtype;
	boolean required;
	
	@OneToMany(mappedBy="field")
	List<ApplicantAdditionalFieldValue> fieldvalues;
	
	@ManyToOne
	Department dept;
	
	
	
	public Integer getFieldId() {
		return fieldId;
	}
	public void setFieldId(Integer fieldId) {
		this.fieldId = fieldId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}
	public boolean isRequired() {
		return required;
	}
	public void setRequired(boolean required) {
		this.required = required;
	}
	public String getFieldtype() {
		return fieldtype;
	}
	public void setFieldtype(String fieldtype) {
		this.fieldtype = fieldtype;
	}
	public List<ApplicantAdditionalFieldValue> getFieldvalues() {
		return fieldvalues;
	}
	public void setFieldvalues(List<ApplicantAdditionalFieldValue> fieldvalues) {
		this.fieldvalues = fieldvalues;
	}
	

}
