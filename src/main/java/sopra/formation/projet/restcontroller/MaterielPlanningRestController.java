ackage sopra.formation.projet.restcontroller;

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

import sopra.formation.projet.model.Materiel;
import sopra.formation.projet.model.MaterielPlanning;
import sopra.formation.projet.model.Planning;
import sopra.formation.projet.service.MaterielPlanningService;


@RestController
@RequestMapping("/rest/materiel")
@CrossOrigin(origins = {"*"})
public class MaterielPlanningRestController {

	@Autowired
	private MaterielPlanningService materielPlanningService;
	
	@GetMapping(path= { "" , "/" })
	public ResponseEntity<List<MaterielPlanning>> findAll(){
		return new ResponseEntity<>(materielPlanningService.showAllMaterielPlanning(), HttpStatus.OK);
	}
	
	@PostMapping(path= { "" , "/" })
	public ResponseEntity<Void> createMateriel(@Valid @RequestBody Materiel materiel, Planning planning , BindingResult result, UriComponentsBuilder uCB){
		ResponseEntity<Void> response = null;
		if(result.hasErrors()) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			materielPlanningService.creatMaterielPlanning(materiel, planning);
			HttpHeaders header = new HttpHeaders();
			header.setLocation(uCB.path("/rest/materiel/{id}").buildAndExpand(materiel.getId()).toUri());
			response = new ResponseEntity<>(header, HttpStatus.CREATED);
		}
		return response;
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Materiel> findById(@PathVariable(name="id") Integer id) {
		Materiel materiel = materielPlanningService.showMaterielById(id);
		ResponseEntity<Materiel> response = null;
		if(materiel != null) {
			response = new ResponseEntity<Materiel>(materiel, HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return response;
	}
	
	@PutMapping(path= { "" , "/" })
	public ResponseEntity<Materiel> update(@Valid @RequestBody Materiel materiel, BindingResult result){
		ResponseEntity<Materiel> response = null;
		if(result.hasErrors() || materiel.getId() == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
		} else {
			Materiel m = materielPlanningService.showMaterielById(materiel.getId());
			if(m != null) {
				Materiel MaterielEnBase = m;
				MaterielEnBase.setCode(m.getCode());
				MaterielEnBase.setCout(m.getCout());
				MaterielEnBase.setMaterielPlanning(m.getMaterielPlanning());
				materielService.modifMateriel(MaterielEnBase);
				response = new ResponseEntity<Materiel>(MaterielEnBase, HttpStatus.OK);
			} else {
				response = new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
			}
		}
		return response;
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable(name="id") Integer id){
		Materiel materiel = materielPlanningService.showMaterielById(id);
		ResponseEntity<Void> response = null;
		if(materiel != null) {
			materielPlanningService.deleteMateriel(materiel);
			response = new ResponseEntity<>(HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return response;
	}
}

