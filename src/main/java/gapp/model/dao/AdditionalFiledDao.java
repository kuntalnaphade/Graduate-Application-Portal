package gapp.model.dao;

import gapp.model.AdditionalField;
import gapp.model.ApplicantAdditionalFieldValue;

public interface AdditionalFiledDao {

	AdditionalField savefield(AdditionalField additionalfield);
	AdditionalField getfieldbyId(int id);
	void removeAdditionalField(AdditionalField additionalfield);
    ApplicantAdditionalFieldValue saveVAlue(ApplicantAdditionalFieldValue value);
}
