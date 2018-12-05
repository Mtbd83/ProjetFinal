package sopra.formation.projet.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sopra.formation.projet.model.Materiel;
import sopra.formation.projet.model.Module;
import sopra.formation.projet.model.Salle;
import sopra.formation.projet.repository.MaterielRepository;

@Service
public class MaterielService {

	@Autowired
	private MaterielRepository materielRepository;
	
	@Autowired
	private PlanningService planningService;
	
	public void createMateriel(Materiel materiel) {
		if (materiel != null) {
			materielRepository.save(materiel);
		}
	}

	public void deleteMateriel(Integer id) {
		Optional<Materiel> opt = materielRepository.findById(id);
		if(opt.isPresent()){
			materielRepository.deleteById(id);
		}
		
	}

	public void deleteAllMateriel() {
		List<Materiel> materiels = materielRepository.findAll();
		for (Materiel materiel : materiels) {
			deleteMateriel(materiel.getId());
		}
	}
	
	public void deleteAllOrdinateur() {
		List<Materiel> materiels = materielRepository.findAllOrdinateur();
		for(Materiel ordinateur : materiels) {
			deleteMateriel(ordinateur.getId());
		}
	}
	
	public void deleteAllSalle() {
		List<Materiel> materiels = materielRepository.findAllSalle();
		for(Materiel salle : materiels) {
			deleteMateriel(salle.getId());
		}
	}
	
	public void deleteAllVideoProjecteur() {
		List<Materiel> materiels = materielRepository.findAllVideoProjecteur();
		for(Materiel videoProjecteur : materiels) {
			deleteMateriel(videoProjecteur.getId());
		}
	}

	public void deleteMateriel(Materiel materiel) {
		deleteMateriel(materiel.getId());
	}

	public List<Materiel> showAll() {
		List<Materiel> materiels = materielRepository.findAll();
		return materiels;
	}

	public Materiel showMateriel(Integer id) {
		Optional<Materiel> opt = materielRepository.findById(id);
		Materiel materiel = null;
		if (opt.isPresent()) {
			materiel = opt.get();
		}
		return materiel;
	}
	
	public List<Materiel> showOrdinateur(){
		List<Materiel> ordinateur = materielRepository.findAllOrdinateur();
		return ordinateur;
	}
	
	public List<Materiel> showSalle(){
		List<Materiel> salle = materielRepository.findAllSalle();
		return salle;
	}
	
	public List<Materiel> showVideoProjecteur(){
		List<Materiel> videoProjecteur = materielRepository.findAllVideoProjecteur();
		return videoProjecteur;
	}
	
	public List<Materiel> showdisponibilite(Date dateDebut, Date dateFin){
		Salle salle = new Salle();
		planningService.showBySalle(salle);
		return materielRepository.findByDisponibilite(true);
	}
	
}


