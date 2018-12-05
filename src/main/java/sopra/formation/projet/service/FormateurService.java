package sopra.formation.projet.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sopra.formation.projet.model.Formateur;
import sopra.formation.projet.model.FormateurMatiere;
import sopra.formation.projet.model.FormateurMatiereKey;
import sopra.formation.projet.model.Matiere;
import sopra.formation.projet.model.Module;
import sopra.formation.projet.repository.FormateurMatiereRepository;
import sopra.formation.projet.repository.FormateurRepository;
import sopra.formation.projet.repository.MatiereRepository;

@Service
public class FormateurService {

	@Autowired
	private FormateurRepository formateurRepository;

	@Autowired
	private FormateurMatiereRepository fmRepository;

	@Autowired
	private MatiereRepository matiereRepository;

	public List<Formateur> listeFormateurs() {
		List<Formateur> formateurs = formateurRepository.findAll();
		return formateurs;
	}

	public List<Formateur> listeFormateurParMatiere(Matiere matiere) {
		List<Formateur> formateurs = formateurRepository.findAllByMatiere(matiere);
		return formateurs;
	}

	public void creerFormateur(Formateur formateur) {
		if (formateur != null) {
			formateurRepository.save(formateur);
		}
	}
	
	public void modifFormateur(Formateur formateur) {
		Optional<Formateur> opt = formateurRepository.findById(formateur.getId());
		Formateur f = new Formateur();
		if(opt.isPresent()) {
			f = opt.get();
		}
		formateurRepository.save(f);
	}

	public void deleteFormateurById(Integer id) {
		Optional<Formateur> opt = formateurRepository.findWithFormateurMatiere(id);
		if (opt.isPresent()) {
			Formateur formateur = opt.get();
			Set<FormateurMatiere> fm = formateur.getFormateurmatiere();
			for (FormateurMatiere formateurMatiere : fm) {
				Optional<FormateurMatiere> optFM = fmRepository.findById(formateurMatiere.getKey());
				if (optFM.isPresent()) {
					fmRepository.delete(formateurMatiere);
				}
			}
		}
		formateurRepository.deleteById(id);
	}

	public void deleteFormateur(Formateur formateur) {
		deleteFormateurById(formateur.getId());
	}

	public void deleteAllFormateur() {
		List<Formateur> formateurs = formateurRepository.findAll();
		for (Formateur f : formateurs) {
			deleteFormateur(f);
		}
	}

	public void ajoutMatiere(Formateur formateur, Matiere matiere) {
		Optional<Formateur> optF = formateurRepository.findById(formateur.getId());
		if (optF.isPresent()) {
			Optional<Matiere> optM = matiereRepository.findById(matiere.getIdMatiere());
			if (optM.isPresent()) {
				Formateur f = optF.get();
				Matiere m = optM.get();
				FormateurMatiere fm = new FormateurMatiere();
				fm.setKey(new FormateurMatiereKey(m, f));
				fmRepository.save(fm);
			}
		}
	}

	public Formateur showFormateurById(Integer id) {
		Optional<Formateur> opt = formateurRepository.findById(id);
		Formateur formateur = null;
		if (opt.isPresent()) {
			formateur = opt.get();
		}
		return formateur;
	}

	public Formateur showFormateurByNom(String nom) {
		Optional<Formateur> opt = formateurRepository.findByNom(nom);
		Formateur formateur = null;
		if (opt.isPresent()) {
			formateur = opt.get();
		}
		return formateur;
	}

	public Formateur showFormateurByPrenom(String prenom) {
		Optional<Formateur> opt = formateurRepository.findByPrenom(prenom);
		Formateur formateur = null;
		if (opt.isPresent()) {
			formateur = opt.get();
		}
		return formateur;
	}
	
	public List<Module> showModuleById(Integer id){
		Optional<Formateur> opt = formateurRepository.findByModuleById(id);
		if(opt.isPresent()) {
			return (List<Module>) opt.get().getModules();
		}else {
			return null;
		}
	}

}
