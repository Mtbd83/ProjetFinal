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

import com.fasterxml.jackson.annotation.JsonView;

import sopra.formation.projet.model.JsonViews;
import sopra.formation.projet.model.Salle;
import sopra.formation.projet.service.SalleService;

@RestController
@RequestMapping("/rest/materiel/salle")
@CrossOrigin(origins = {"*"})
public class SalleRestController {

	@Autowired
	private SalleService salleService;
	
	@GetMapping(path= { "" , "/" })
	@JsonView(JsonViews.Common.class)
	public ResponseEntity<List<Salle>> findAllSalle(){
		return new ResponseEntity<>(salleService.showAllSalle(), HttpStatus.OK);
	}
	
	@PostMapping(path= { "" , "/" })
	@JsonView(JsonViews.Common.class)
	public ResponseEntity<Void> createSalle(@Valid @RequestBody Salle salle, BindingResult result, UriComponentsBuilder uCB){
		ResponseEntity<Void> response = null;
		if(result.hasErrors()) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			salleService.createSalle(salle);
			HttpHeaders header = new HttpHeaders();
			header.setLocation(uCB.path("/rest/materiel/salle/{id}").buildAndExpand(salle.getId()).toUri());
			response = new ResponseEntity<>(header, HttpStatus.CREATED);
		}
		return response;
	}
	
	@GetMapping(value="/{id}")
	@JsonView(JsonViews.Common.class)
	public ResponseEntity<Salle> findById(@PathVariable(name="id") Integer id) {
		Salle salle = salleService.showSalleById(id);
		ResponseEntity<Salle> response = null;
		if(salle != null) {
			response = new ResponseEntity<Salle>(salle, HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return response;
	}
	
	@PutMapping(path= { "" , "/" })
	@JsonView(JsonViews.SalleAvecPlanning.class)
	public ResponseEntity<Salle> update(@Valid @RequestBody Salle salle, BindingResult result){
		ResponseEntity<Salle> response = null;
		if(result.hasErrors() || salle.getId() == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
		} else {
			Salle salleEnBase = salleService.showSalleById(salle.getId());
			salleEnBase.setCode(salle.getCode());
			salleEnBase.setCout(salle.getCout());
			salleEnBase.setCapacite(salle.getCapacite());
			salleEnBase.setDisponibilite(salle.isDisponibilite());
			salleEnBase.setMaterielPlanning(salle.getMaterielPlanning());
			salleEnBase.setPlanning(salle.getPlanning());
			salleService.update(salleEnBase);
			response = new ResponseEntity<Salle>(salleEnBase, HttpStatus.OK);

		}
		return response;
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable(name="id") Integer id){
		Salle salle = salleService.showSalleById(id);
		ResponseEntity<Void> response = null;
		if(salle != null) {
			salleService.deleteSalle(salle);
			response = new ResponseEntity<>(HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return response;
	}
	
}
