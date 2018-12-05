package sopra.formation.projet.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sopra.formation.projet.model.FormateurMatiere;
import sopra.formation.projet.model.Matiere;
import sopra.formation.projet.model.Module;
import sopra.formation.projet.repository.MatiereRepository;

@Service
public class MatiereService {

	
	@Autowired(required=true)
	private MatiereRepository matiereRepository;

	public void createMatiere(Matiere matiere) {
		if (matiere != null) {
			matiereRepository.save(matiere);
		}
	}

	public void deleteMatiere(Matiere matiere) {
		if (matiere != null) {
			matiereRepository.delete(matiere);
		}
	}

	public List<Matiere> findAll() {
		List<Matiere> matieres = matiereRepository.findAll();
		return matieres;
	}

	public Matiere findMatiere(Integer idMatiere) {
		Optional<Matiere> opt = matiereRepository.findById(idMatiere);
		Matiere matiere = new Matiere();
		if (opt.isPresent()) {
			matiere = opt.get();
		}
		return matiere;
	}

	public void update(Matiere matiere, String titre, Integer duree, String objectif, String prerequis, String contenu, Module module, Set<FormateurMatiere> formateursMatieres) {
		if (titre != matiere.getTitre()) {
			matiere.setTitre(titre);
		} else if ( duree != matiere.getDuree()) {
				matiere.setDuree(duree);
		}else if (objectif != matiere.getObjectif()) {
				matiere.setObjectif(objectif);
			}else if (prerequis != matiere.getPrerequis()) {
					matiere.setPrerequis(prerequis);
			}else if (contenu != matiere.getContenu()) {
					matiere.setContenu(contenu);
			}else if (module != matiere.getModule()) {
				matiere.setModule(module);
			}else if (formateursMatieres != matiere.getFormateursMatieres()) {
				matiere.setFormateursMatieres(formateursMatieres);		
			}
	
		matiereRepository.save(matiere);
	}
}
