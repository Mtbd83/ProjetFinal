package sopra.formation.projet.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.formation.projet.model.FormateurMatiere;
import sopra.formation.projet.model.Matiere;
import sopra.formation.projet.model.Module;

public interface MatiereRepository extends JpaRepository<Matiere,Integer>{

	Optional<Matiere> findByTitre(String titre);

	List<Matiere> findByDuree(Integer duree);

	Optional<Matiere> findByObjectif(String objectif);

	List<Matiere> findByPrerequis(String prerequis);

	Optional<Matiere> findByContenu(String contenu);
	
	List<Matiere> findByModule(Module module);
	
	Set<FormateurMatiere> findByFormateursMatieres(FormateurMatiere formateursMatieres);
	
	@Query("select distinct m from Matiere m left join fetch m.module")
	List<Matiere> findMatiereWithModule();
	
	
	@Query("select distinct m from Matiere m left join fetch m.module where m.idMatiere=:id")
	Optional<Matiere> findMatiereWithModuleById(@Param("id")Integer id);	

	@Query("select distinct m from Matiere m left join fetch m.formateursMatieres where m.idMatiere=:id")
	Optional<Matiere> findMatiereWithFormateurById(@Param("id")Integer id);
	
	

}
