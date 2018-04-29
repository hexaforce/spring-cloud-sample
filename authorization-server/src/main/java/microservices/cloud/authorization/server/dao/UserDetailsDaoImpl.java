package microservices.cloud.authorization.server.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDetailsDaoImpl implements UserDetailsDao {

//	@Autowired
//	private SessionFactory sessionFactory;

	@Override
	public User findUserByUsername(String username) {
		return null;//sessionFactory.getCurrentSession().get(User.class, username);
	}
	
}
