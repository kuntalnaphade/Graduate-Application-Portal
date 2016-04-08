package gapp.model.dao;



import java.util.List;

import gapp.model.Department;
import gapp.model.Status;
import gapp.model.StatusAudit;
import gapp.model.Term;;

public interface StatusDao {
List<Status> getallStatus();
Status getStatusbyname(String status);
Status getStatusbyid(int id);
StatusAudit saveStatus(StatusAudit audit);
}
