package sopra.formation.projet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sopra.formation.projet.model.Materiel;
import sopra.formation.projet.model.Ordinateur;
import sopra.formation.projet.model.Salle;
import sopra.formation.projet.model.VideoProjecteur;
import sopra.formation.projet.repository.MaterielRepository;

@Service
public class MaterielService {

	@Autowired
	private MaterielRepository materielRepository;
	
	
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
		List<Ordinateur> materiels = materielRepository.findAllOrdinateur();
		for(Materiel ordinateur : materiels) {
			deleteMateriel(ordinateur.getId());
		}
	}
	
	public void deleteAllSalle() {
		List<Salle> materiels = materielRepository.findAllSalle();
		for(Materiel salle : materiels) {
			deleteMateriel(salle.getId());
		}
	}
	
	public void deleteAllVideoProjecteur() {
		List<VideoProjecteur> materiels = materielRepository.findAllVideoProjecteur();
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
	
	public Materiel showMaterielById(Integer id) {
		Optional<Materiel> opt = materielRepository.findById(id);
		Materiel materiel = null;
		if (opt.isPresent()) {
			materiel = opt.get();
		}
		return materiel;
	}

	public Materiel showMateriel(Integer id) {
		Optional<Materiel> opt = materielRepository.findById(id);
		Materiel materiel = null;
		if (opt.isPresent()) {
			materiel = opt.get();
		}
		return materiel;
	}
	
	public List<Ordinateur> showOrdinateur(){
		List<Ordinateur> ordinateur = materielRepository.findAllOrdinateur();
		return ordinateur;
	}
	
	public List<Salle> showSalle(){
		List<Salle> salles = materielRepository.findAllSalle();
		return salles;
	}
	
	public List<VideoProjecteur> showVideoProjecteur(){
		List<VideoProjecteur> videoProjecteur = materielRepository.findAllVideoProjecteur();
		return videoProjecteur;
	}
	
	public void modifMateriel(Materiel materiel) {
		List<Materiel> materiels = materielRepository.findAll();
		for(Materiel m : materiels) {
			if(m.getId().equals(m.getId())) {
				materielRepository.save(m);
			}
		}
	}
	
	
}


