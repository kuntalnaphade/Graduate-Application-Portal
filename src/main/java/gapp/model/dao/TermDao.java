package gapp.model.dao;



import java.util.List;

import gapp.model.Department;
import gapp.model.Term;;

public interface TermDao {

List<Term> getallTerms();
Term getTermbyid(int termid);

}
