package sopra.formation.projet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sopra.formation.projet.model.MaterielPlanning;
import sopra.formation.projet.model.MaterielPlanningKey;

public interface MaterielPlanningRepository extends JpaRepository<MaterielPlanning, MaterielPlanningKey> {


	@Query("select distinct s from Salle s")
	List<MaterielPlanning> findAllSalle();

}
