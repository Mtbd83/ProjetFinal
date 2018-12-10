package sopra.formation.projet.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.formation.projet.model.Login;

public interface LoginRepository extends JpaRepository<Login, String> {
		
	@Query("select u from Login u left join fetch u.roles where u.username=?1")
	Optional<Login> findByIdWithRoles(String username);
	
	@Query("select l from Login l where l.username=:username")
	Optional<Login> findWithUsername(@Param("username") String username);
	
	@Query("select l from Login l where l.password=:password")
	Optional<Login> findWithPassword(@Param("password") String password);

	
		
}


