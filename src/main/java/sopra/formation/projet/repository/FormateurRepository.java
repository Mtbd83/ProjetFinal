package sopra.formation.projet.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.formation.projet.model.Formateur;
import sopra.formation.projet.model.Matiere;

public interface FormateurRepository extends JpaRepository<Formateur,Integer> {

	Optional<Formateur> findById(Integer id);
	
	Optional<Formateur> findByNom(String nom);
	
	Optional<Formateur> findByPrenom(String nom);
	
	@Query("select distinct f from Formateur f left join fetch f.formateurmatiere fm "
			+ "left join fetch fm.key.matiere where fm.key.matiere=:matiere")
	List<Formateur> findAllByMatiere(@Param("matiere") Matiere matiere);
	
	@Query("select distinct f from Formateur f left join fetch f.formateurmatiere")
	Optional<Formateur> findWithFormateurMatiere(Integer id);
}
