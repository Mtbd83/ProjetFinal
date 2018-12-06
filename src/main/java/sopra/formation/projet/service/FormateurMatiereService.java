package sopra.formation.projet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sopra.formation.projet.model.Formateur;
import sopra.formation.projet.model.FormateurMatiere;
import sopra.formation.projet.model.FormateurMatiereKey;
import sopra.formation.projet.model.Matiere;
import sopra.formation.projet.repository.FormateurMatiereRepository;


@Service
public class FormateurMatiereService {

	@Autowired
	private FormateurMatiereRepository formateurMatiereRepository;

	public void creerFormateurMatiere(Formateur formateur, Matiere matiere) {
		FormateurMatiereKey formateurMatiereKey = new FormateurMatiereKey();
		formateurMatiereKey.setFormateur(formateur);
		formateurMatiereKey.setMatiere(matiere);
		FormateurMatiere formateurMatiere = new FormateurMatiere();
		formateurMatiere.setKey(formateurMatiereKey);
		formateurMatiereRepository.save(formateurMatiere);
	}

	public void deleteFormateurMatiere(FormateurMatiere formateurMatiere) {
		formateurMatiereRepository.delete(formateurMatiere);
	}

	public void deleteFormateurMatiereByFormateur(Formateur formateur) {
		List<FormateurMatiere> formateurMatieres = formateurMatiereRepository.findAll();
		for (FormateurMatiere formateurMatiere : formateurMatieres) {
			if (formateurMatiere.getKey().getFormateur().equals(formateur)) {
				formateurMatiereRepository.delete(formateurMatiere);
			}
		}
	}

	public void deleteFormateurMatiereByMatiere(Matiere matiere) {
		List<FormateurMatiere> formateurMatieres = formateurMatiereRepository.findAll();
		for (FormateurMatiere formateurMatiere : formateurMatieres) {
			if (formateurMatiere.getKey().getMatiere().equals(matiere)) {
				formateurMatiereRepository.delete(formateurMatiere);
			}
		}
	}

	public List<FormateurMatiere> findAllFormateurMatiere() {
		return formateurMatiereRepository.findAll();
	}
	
	public FormateurMatiere findOne(FormateurMatiereKey key) {
		Optional<FormateurMatiere> opt = formateurMatiereRepository.findById(key);
		FormateurMatiere fm = new FormateurMatiere();
		if(opt.isPresent()) {
			fm = opt.get();
		}
		return fm;
	}
	
}
