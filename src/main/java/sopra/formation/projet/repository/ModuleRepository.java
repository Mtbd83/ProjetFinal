package sopra.formation.projet.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.formation.projet.model.Formateur;
import sopra.formation.projet.model.Matiere;
import sopra.formation.projet.model.Module;
import sopra.formation.projet.model.Planning;

public interface ModuleRepository extends JpaRepository<Module, Integer> {

	List<Module> findByFormateur(Formateur formateur);

	List<Module> findByPlanning(Planning planning);

	Optional<Module> findByDateDebut(Date date);

	Optional<Module> findByDateFin(Date date);

	Optional<Module> findByMatiere(Matiere matiere);

	@Query("select distinct m from Module m left join fetch m.modulesStagiaires ms left join fetch "
			+ "ms.key.stagiaire")
	List<Module> findModuleWithStagiare();

	@Query("select m from Module m left join fetch m.modulesStagiaires ms left join fetch "
			+ "ms.key.stagiaire where m.idModule=:num")
	Optional<Module> findByIdWithStagiaire(@Param("num") Integer id);


}
