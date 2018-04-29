package microservices.cloud.authorization.server.dao;

public interface UserDetailsDao {
	User findUserByUsername(String username);
}
