package sopra.formation.projet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sopra.formation.projet.model.Materiel;

public interface MaterielRepository extends JpaRepository<Materiel, Integer> {

	List<Materiel> findAll();
	
	@Query("select distinct o from Ordinateur o")
	List<Materiel> findAllOrdinateur();
	
	@Query("select distinct s from Salle s")
	List<Materiel> findAllSalle();
	
	@Query("select distinct vp from VideoProjecteur vp")
	List<Materiel> findAllVideoProjecteur();
	
	List<Materiel> findByDisponibilite(boolean disponibilite);
}
