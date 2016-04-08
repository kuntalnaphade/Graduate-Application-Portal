package gapp.model.dao;



import java.util.List;




import gapp.model.EducationalBackground;


public interface EduBackgroundDao {

List<EducationalBackground> getalleduBackground();
EducationalBackground getEdubckgroundid(int eduid);
EducationalBackground saveEduDetails(EducationalBackground educationalBackground);
void removeeduBachgroundbyId(EducationalBackground edu);
}
