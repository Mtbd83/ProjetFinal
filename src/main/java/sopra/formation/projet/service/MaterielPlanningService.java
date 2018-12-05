package sopra.formation.projet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sopra.formation.projet.model.Materiel;
import sopra.formation.projet.model.MaterielPlanning;
import sopra.formation.projet.model.MaterielPlanningKey;
import sopra.formation.projet.model.Planning;
import sopra.formation.projet.repository.MaterielPlanningRepository;
import sopra.formation.projet.repository.MaterielRepository;



@Service
public class MaterielPlanningService {

	@Autowired
	private MaterielPlanningRepository materielPlanningRepository;
	
	@Autowired
	private MaterielRepository materielRepository;

	public void creatMaterielPlanning(Materiel materiel, Planning planning) {
		MaterielPlanningKey materielPlanningKey = new MaterielPlanningKey();
		materielPlanningKey.setMateriel(materiel);
		materielPlanningKey.setPlanning(planning);
		MaterielPlanning materielPlanning = new MaterielPlanning();
		materielPlanning.setKey(materielPlanningKey);
		materielPlanningRepository.save(materielPlanning);
	}
	
	public void deleteMaterielPlanning(MaterielPlanning materielPlanning) {
		materielPlanningRepository.delete(materielPlanning);
	}

	
	public void deleteByMateriel(Materiel materiel) {
		List<MaterielPlanning> materielsPlannings = materielPlanningRepository.findAll();
		for(MaterielPlanning materielPlanning : materielsPlannings) {
			if(materielPlanning.getKey().getMateriel().equals(materiel)){
				materielPlanningRepository.delete(materielPlanning);
			}
		}
	}
	
	public void deleteByPlanning(Planning planning) {
		List<MaterielPlanning> materielsPlannings = materielPlanningRepository.findAll();
		for(MaterielPlanning materielPlanning : materielsPlannings) {
			if (materielPlanning.getKey().getPlanning().equals(planning)) {
				materielPlanningRepository.delete(materielPlanning);
			}
		}
	}

	public List<MaterielPlanning> showAllMaterielPlanning(){
		return materielPlanningRepository.findAll();
	}


	public List<Materiel> showSalleLibre(){
		List<Materiel> salles = materielRepository.findAllSalle();
		List<MaterielPlanning> materielsPlanning = materielPlanningRepository.findAll();
		for(Materiel salle: salles) {
			for(MaterielPlanning materielPlanning : materielsPlanning) {
				if (salle.getId().equals(materielPlanning.getKey().getMateriel().getId())) {
					salles.remove(salle);
				}
			}
		}
		return salles;
	}
	
	public List<Materiel> showOrdinateurLibre(){
		List<Materiel> ordinateurs = materielRepository.findAllOrdinateur();
		List<MaterielPlanning> materielsPlanning = materielPlanningRepository.findAll();
		for(Materiel ordinateur: ordinateurs) {
			for(MaterielPlanning materielPlanning : materielsPlanning) {
				if (ordinateur.getId().equals(materielPlanning.getKey().getMateriel().getId())) {
					ordinateurs.remove(ordinateur);
				}
			}
		}
		return ordinateurs;
	}
	
	public List<Materiel> showVideoProjLibre(){
		List<Materiel> videoProjecteurs = materielRepository.findAllVideoProjecteur();
		List<MaterielPlanning> materielsPlanning = materielPlanningRepository.findAll();
		for(Materiel videoProjecteur: videoProjecteurs) {
			for(MaterielPlanning materielPlanning : materielsPlanning) {
				if (videoProjecteur.getId().equals(materielPlanning.getKey().getMateriel().getId())) {
					videoProjecteurs.remove(videoProjecteur);
				}
			}
		}
		return videoProjecteurs;
	}
}
