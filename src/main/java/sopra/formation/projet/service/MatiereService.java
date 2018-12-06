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
	
	public void update(Matiere matiere) {
		Optional<Matiere> opt = matiereRepository.findById(matiere.getIdMatiere());
		Matiere m = new Matiere();
		if(opt.isPresent()) {
			m = opt.get();
			matiereRepository.save(m);
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
	
	public List<Matiere> findAllWithModule() {
		List<Matiere> matieres = matiereRepository.findMatiereWithModule();
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
	
	public Matiere findMatiereWithModule(Integer idMatiere) {
		Optional<Matiere> opt = matiereRepository.findMatiereWithModuleById(idMatiere);
		Matiere matiere = new Matiere();
		if (opt.isPresent()) {
			matiere = opt.get();
		}
		return matiere;
	}
	

}
