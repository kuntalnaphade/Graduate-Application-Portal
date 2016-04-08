package gapp.model.dao.jpa;

import java.util.List;

import gapp.model.User;
import gapp.model.UserType;
import gapp.model.dao.UserDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
    	 return entityManager.merge( user );
	}

	@Override
	public UserType getUserTpe(String type) {
		// TODO Auto-generated method stub
		UserType objType=entityManager.createQuery("from UserType where type= :name",UserType.class).setParameter("name", type).getSingleResult();
		return objType;
	}

	@Override
	public List<User> getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return entityManager.createQuery("from User where email_id= :email",User.class).setParameter("email", email).getResultList();
	}

  /* @Override
    public User getUser( Integer id )
    {
        return entityManager.find( User.class, id );
    }

    @Override
    public List<User> getUsers()
    {
        return entityManager.createQuery( "from User order by id", User.class )
            .getResultList();
    }
*/
    

}