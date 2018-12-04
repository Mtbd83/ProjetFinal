package sopra.formation.projet.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sopra.formation.projet.model.FormateurMatiereKey;
import sopra.formation.projet.model.FormateurMatiere;

public interface FormateurMatiereRepository extends JpaRepository<FormateurMatiere, FormateurMatiereKey>{

	Optional<FormateurMatiere> findByKey(FormateurMatiereKey key);
	
}
