package sopra.formation.projet.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.formation.projet.model.Planning;
import sopra.formation.projet.model.Salle;

public interface PlanningRepository extends JpaRepository<Planning,Integer>{
	
	Optional<Planning> findByDateDebut(Date date);
	Optional<Planning> findByDateFin(Date date);
	Optional<Planning> findBySalle(Salle salle);
	List<Planning> findByDateDebutBetween(Date date1, Date date2);
	
	@Query("select distinct p from Planning p left join fetch p.modules")
	List<Planning> findAllWithModules();
	
	@Query("select distinct p from Planning p left join fetch p.modules where p.idPlanning=:id")
	Optional<Planning> findByIdWithModules(@Param("id") Integer id);

}
