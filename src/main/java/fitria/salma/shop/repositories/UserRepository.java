package fitria.salma.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fitria.salma.shop.entities.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

	@Query(nativeQuery = true,
			value = "select * from m_user where username ilike :username")
	public UserEntity getUserByUsername(@Param("username") String username);
	
	@Query(nativeQuery = true,
			value = "select exists (select * from m_user where username ilike :username and is_delete is false)")
	public Boolean isUsernameExists(@Param("username") String username);
	
	@Query(nativeQuery = true,
			value = "select exists (select * from m_user where username ilike :username and password ilike :password and is_delete is false)")
	public Boolean isLoginSuccess(@Param("username") String username, @Param("password") String password);
}
