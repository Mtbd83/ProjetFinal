package sopra.formation.projet.repository;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.formation.projet.model.Planning;
import sopra.formation.projet.model.Salle;

public interface PlanningRepository extends JpaRepository<Planning,Integer>{
	
	Optional<Planning> findByDateDebut(Date date);
	Optional<Planning> findByDateFin(Date date);
	Optional<Planning> findBySalle(Salle salle);

}
