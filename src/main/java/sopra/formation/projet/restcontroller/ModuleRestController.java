package sopra.formation.projet.restcontroller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import sopra.formation.projet.model.Module;
import sopra.formation.projet.service.ModuleService;

@RestController
@RequestMapping("/rest/module")
@CrossOrigin(origins= {"*"})
public class ModuleRestController {
	
	@Autowired
	private ModuleService moduleService;
	
	
	@GetMapping(path= {"","/"})
	public ResponseEntity<List<Module>> findAll(){
		return new ResponseEntity<>(moduleService.showAll(),HttpStatus.OK);
	}
	
	
	@PostMapping(path= {"","/"})
	public ResponseEntity<Void> create(@Valid @RequestBody Module module, BindingResult br, UriComponentsBuilder uCB){
		ResponseEntity<Void> response = null;
		if(br.hasErrors()) {
			response=new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}else {
			moduleService.createModule(module);;
			HttpHeaders header = new HttpHeaders();
			header.setLocation(uCB.path("/rest/Module/{idModule}").buildAndExpand(module.getIdModule()).toUri());
			response=new ResponseEntity<>(header,HttpStatus.CREATED);
		}
		return response;
		
	}
	
	@GetMapping(value="/{idModule}")
	public ResponseEntity<Module>findById(@PathVariable (name="idModule") Integer id){
		Module Module = moduleService.showById(id);
		ResponseEntity<Module> response = null;
		if (Module!=null) {
			response=new ResponseEntity<Module>(Module,HttpStatus.OK);
		}else {
			response=new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return response;
	}
	
	@PutMapping(path= {"","/"})
	public ResponseEntity<Module> update(@Valid @RequestBody Module module,BindingResult br, UriComponentsBuilder uCB){
		ResponseEntity<Module> response = null;
		if(br.hasErrors()||module.getIdModule()==null) {
			response=new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
		}else {
			Module moduleEnBase = moduleService.showById(module.getIdModule());
			moduleEnBase.setDateDebut(moduleEnBase.getDateDebut());
			moduleEnBase.setDateFin(moduleEnBase.getDateFin());
			moduleEnBase.setFormateur(moduleEnBase.getFormateur());
			moduleEnBase.setMatiere(moduleEnBase.getMatiere());
			moduleEnBase.setModulesStagiaires(moduleEnBase.getModulesStagiaires());
			moduleEnBase.setPlanning(moduleEnBase.getPlanning());
			response=new ResponseEntity<Module>(moduleEnBase,HttpStatus.OK);
		}
		return response;
	}
	
	@DeleteMapping(value="/{idModule}")
	public ResponseEntity<Void> delete(@PathVariable (name="idModule")Integer id){
		ResponseEntity<Void> response = null;
		Module Module = moduleService.showById(id);
		if(Module!=null) {
			moduleService.deleteModule(id);
			response=new ResponseEntity<>(HttpStatus.OK);
		}else {
			response=new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return response;
	}
	
}
