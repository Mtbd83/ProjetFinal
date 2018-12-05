package sopra.formation.projet.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sopra.formation.projet.model.Login;

public interface LoginRepository extends JpaRepository<Login, String> {
		
	@Query("select u from Users u left join fetch u.roles where u.username=?1")
	public Optional<Login> findByIdWithRoles(String username);
		
}


