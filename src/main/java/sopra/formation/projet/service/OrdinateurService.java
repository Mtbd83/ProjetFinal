package sopra.formation.projet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sopra.formation.projet.model.Ordinateur;
import sopra.formation.projet.repository.MaterielRepository;

@Service
public class OrdinateurService {

	@Autowired
	private MaterielRepository materielRepository;
	
	
	public void createOrdinateur(Ordinateur ordinateur) {
		if (ordinateur != null) {
			materielRepository.save(ordinateur);
		}
	}
	
	public void update(Ordinateur ordinateur) {
		Optional<Ordinateur> opt = materielRepository.findOrdinateurById(ordinateur.getId());
		Ordinateur o = new Ordinateur();
		if(opt.isPresent()) {
			o = opt.get();
			materielRepository.save(o);
		}
	}

	public void deleteOrdinateurById(Integer id) {
		materielRepository.deleteById(id);
		
	}

	public void deleteAllOrdinateur() {
		List<Ordinateur> ordinateurs = materielRepository.findAllOrdinateur();
		for (Ordinateur ordinateur : ordinateurs) {
			deleteOrdinateurById(ordinateur.getId());
		}
	}
	
	public void deleteOrdinateur(Ordinateur ordinateur) {
		deleteOrdinateurById(ordinateur.getId());
	}

	public List<Ordinateur> showAllOrdinateur() {
		List<Ordinateur> ordinateurs = materielRepository.findAllOrdinateur();
		return ordinateurs;
	}
	
	public Ordinateur showOrdinateurById(Integer id) {
		Optional<Ordinateur> opt = materielRepository.findOrdinateurById(id);
		Ordinateur ordinateur = null;
		if (opt.isPresent()) {
			ordinateur = opt.get();
		}
		return ordinateur;
	}
	
	
	public List<Ordinateur> showOrdinateur(){
		List<Ordinateur> ordinateur = materielRepository.findAllOrdinateur();
		return ordinateur;
	}
	
	
	public void modifOrdinateur(Ordinateur ordinateur) {
		List<Ordinateur> ordinateurs = materielRepository.findAllOrdinateur();
		for(Ordinateur m : ordinateurs) {
			if(m.getId().equals(m.getId())) {
				materielRepository.save(m);
			}
		}
	}
	
}
