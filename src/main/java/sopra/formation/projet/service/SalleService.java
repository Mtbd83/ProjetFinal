package sopra.formation.projet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sopra.formation.projet.model.Salle;
import sopra.formation.projet.repository.MaterielRepository;

@Service
public class SalleService {

	@Autowired
	private MaterielRepository materielRepository;
	
	
	public void createSalle(Salle salle) {
		if (salle != null) {
			materielRepository.save(salle);
		}
	}
	
	public void update(Salle salle) {
		Optional<Salle> opt = materielRepository.findSalleById(salle.getId());
		Salle s = new Salle();
		if(opt.isPresent()) {
			s = opt.get();
		}
		materielRepository.save(s);
	}

	public void deleteSalleById(Integer id) {
		materielRepository.deleteById(id);
		
	}

	public void deleteAllSalle() {
		List<Salle> salles = materielRepository.findAllSalle();
		for (Salle salle : salles) {
			deleteSalleById(salle.getId());
		}
	}
	
	public void deleteSalle(Salle salle) {
		deleteSalleById(salle.getId());
	}

	public List<Salle> showAllSalle() {
		List<Salle> salles = materielRepository.findAllSalle();
		return salles;
	}
	
	public Salle showSalleById(Integer id) {
		Optional<Salle> opt = materielRepository.findSalleById(id);
		Salle salle = null;
		if (opt.isPresent()) {
			salle = opt.get();
		}
		return salle;
	}
	
	
	public List<Salle> showSalle(){
		List<Salle> salle = materielRepository.findAllSalle();
		return salle;
	}
	
	
	public void modifSalle(Salle salle) {
		List<Salle> salles = materielRepository.findAllSalle();
		for(Salle s : salles) {
			if(s.getId().equals(s.getId())) {
				materielRepository.save(s);
			}
		}
	}
	
}
