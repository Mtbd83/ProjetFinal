package sopra.formation.projet.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sopra.formation.projet.model.Formateur;
import sopra.formation.projet.model.Matiere;
import sopra.formation.projet.model.Module;
import sopra.formation.projet.model.Planning;
import sopra.formation.projet.repository.ModuleRepository;

@Service
public class ModuleService {
	
	@Autowired
	private ModuleRepository moduleRepo;
	
	
	public void createModule(Module module) {
		if (module!=null) {
			moduleRepo.save(module);
		}
	}
	
	public void deleteModule(Integer idModule) {
		Optional<Module> opt = moduleRepo.findById(idModule);
		if (opt.isPresent()) {
			moduleRepo.deleteById(idModule);
		}
		
	}
	
	public List<Module> showAll(){
		return moduleRepo.findAll();
	}
	
	public Module showById(Integer idModule) {
		Optional<Module> opt = moduleRepo.findById(idModule);
		if (opt.isPresent()) {
			return opt.get();
		}else {
			return null;
		}
	}
	

	
	public void updateModule(Module module) {
	Optional<Module> opt = moduleRepo.findById(module.getIdModule());
	if(opt.isPresent()) {
		moduleRepo.save(opt.get());
	}
}
	
	public List<Module> showByFormateur(Formateur formateur){
		return moduleRepo.findByFormateur(formateur);
	}
	
	
	public List<Module> showByPlanning(Planning planning){
		return moduleRepo.findByPlanning(planning);
	}
	
	
	public Module showByDateDebut(Date date) {
		Optional<Module> opt = moduleRepo.findByDateDebut(date);
		if (opt.isPresent()) {
			return opt.get();
		}else {
			return null;
		}
	}
	public Module showByDateFin(Date date) {
		Optional<Module> opt = moduleRepo.findByDateFin(date);
		if (opt.isPresent()) {
			return opt.get();
		}else {
			return null;
		}
	}
	
	public Module showByMatiere(Matiere matiere) {
		Optional<Module> opt = moduleRepo.findByMatiere(matiere);
		if (opt.isPresent()) {
			return opt.get();
		}else {
			return null;
		}
	}
	
	public List<Module> showModuleWithStagiaire(){
		return moduleRepo.findModuleWithStagiare();
	}
	
	public Module showModuleWithStagiaireById(Integer idModule) {
		Optional<Module> opt = moduleRepo.findByIdWithStagiaire(idModule);
		if(opt.isPresent()) {
			return opt.get();
		}else {
			return null;
		}
	}
	
	public Formateur showFormateurByModuleId(Integer idModule) {
		Optional<Module> module = moduleRepo.findById(idModule);
		if (module.isPresent()) {
			return module.get().getFormateur();
		} else {
			return null;
		}
	}


}
