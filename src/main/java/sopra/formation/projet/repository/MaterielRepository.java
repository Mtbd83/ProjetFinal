package sopra.formation.projet.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sopra.formation.projet.model.Materiel;
import sopra.formation.projet.model.Ordinateur;
import sopra.formation.projet.model.Salle;
import sopra.formation.projet.model.VideoProjecteur;

public interface MaterielRepository extends JpaRepository<Materiel, Integer> {

	List<Materiel> findAll();
	
	@Query("select distinct o from Ordinateur o")
	List<Ordinateur> findAllOrdinateur();
	
	@Query("select distinct s from Salle s")
	List<Salle> findAllSalle();
	
	@Query("select distinct vp from VideoProjecteur vp")
	List<VideoProjecteur> findAllVideoProjecteur();
	
	Optional<Ordinateur> findOrdinateurById(Integer id);
	Optional<Salle> findSalleById(Integer id);
	Optional<VideoProjecteur> findVideoProjecteurById(Integer id);
	
}
