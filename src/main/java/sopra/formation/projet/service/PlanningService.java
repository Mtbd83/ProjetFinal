package sopra.formation.projet.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sopra.formation.projet.model.Planning;
import sopra.formation.projet.model.Salle;
import sopra.formation.projet.repository.PlanningRepository;

@Service
public class PlanningService {
	
	@Autowired
	private PlanningRepository planningRepo;
	
	public void createPlanning(Planning planning) {
		if(planning!=null) {
			planningRepo.save(planning);
		}
	}
	
	public void deletePlanning(Integer idPlanning) {
		Optional<Planning> opt = planningRepo.findById(idPlanning);
		if (opt.isPresent()) {
			planningRepo.deleteById(idPlanning);
		}
	}
	
	public Planning showById(Integer idPlanning) {
		Optional<Planning> opt = planningRepo.findById(idPlanning);
		if (opt.isPresent()) {
			return opt.get();
		}
		return null;
	}
	
	
	public List<Planning> showAll(){
		return planningRepo.findAll();
	}
	
	public void updatePlanning(Integer idPlanning) {
		Optional<Planning> opt = planningRepo.findById(idPlanning);
		if (opt.isPresent()) {
			planningRepo.save(opt.get());
		}
	}
	
	public Planning showByDateFin(Date date) {
		Optional<Planning> opt = planningRepo.findByDateFin(date);
		if (opt.isPresent()) {
			return opt.get();
		}else {
			return null;
		}
	}
	
	public Planning showByDateDebut(Date date) {
		Optional<Planning> opt = planningRepo.findByDateDebut(date);
		if (opt.isPresent()) {
			return opt.get();
		}else {
			return null;
		}
	}
	
	public Planning showBySalle(Salle salle) {
		Optional<Planning> opt = planningRepo.findBySalle(salle);
		if (opt.isPresent()) {
			return opt.get();
		}else {
			return null;
		}
	}
	
	public List<Planning> showByDateDebutBetween(Date date1, Date date2){
		List<Planning> plannings= planningRepo.findByDateDebutBetween(date1, date2);
		return plannings;
	}
	
	

}
