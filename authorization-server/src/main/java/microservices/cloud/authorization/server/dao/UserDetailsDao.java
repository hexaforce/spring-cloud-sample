package microservices.cloud.authorization.server.dao;

import microservices.cloud.authorization.server.model.User;

public interface UserDetailsDao {
	User findUserByUsername(String username);
}
