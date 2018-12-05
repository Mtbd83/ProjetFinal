package sopra.formation.projet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.formation.projet.model.FormateurMatiereKey;
import sopra.formation.projet.model.FormateurMatiere;

public interface FormateurMatiereRepository extends JpaRepository<FormateurMatiere, FormateurMatiereKey>{
	
}
