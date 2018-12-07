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
import sopra.formation.projet.model.Module;
import sopra.formation.projet.model.Planning;
import sopra.formation.projet.service.PlanningService;

@RestController
@RequestMapping("/rest/planning")
@CrossOrigin(origins= {"*"})
public class PlanningRestController {
	
	@Autowired
	private PlanningService planningService;
	
	
	@GetMapping(path= {"","/"})
	@JsonView(JsonViews.Planning.class)
	public ResponseEntity<List<Planning>> findAll(){
		return new ResponseEntity<>(planningService.showAllWithModules(),HttpStatus.OK);
	}
	
	@GetMapping(path= {"/module"})
	@JsonView(JsonViews.PlanningAvecModule.class)
	public ResponseEntity<List<Planning>> findAllWithModules() {
		return new ResponseEntity<>(planningService.showAllWithModules(),HttpStatus.OK);
	}
	
	@GetMapping(path= {"/module/{idPlanning}"})
	@JsonView(JsonViews.PlanningAvecModule.class)
	public ResponseEntity<Planning> findByIdWithModules(@PathVariable(name="idPlanning") Integer id) {
		return new ResponseEntity<>(planningService.showByIdWithModules(id),HttpStatus.OK);
	}
	
	
	@PostMapping(path= {"","/"})
	@JsonView(JsonViews.Planning.class)
	public ResponseEntity<Void> create(@Valid @RequestBody Planning planning, BindingResult br, UriComponentsBuilder uCB){
		ResponseEntity<Void> response = null;
		if(br.hasErrors()) {
			response=new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}else {
			planningService.createPlanning(planning);
			HttpHeaders header = new HttpHeaders();
			header.setLocation(uCB.path("/rest/planning/{idPlanning}").buildAndExpand(planning.getIdPlanning()).toUri());
			response=new ResponseEntity<>(header,HttpStatus.CREATED);
		}
		return response;
		
	}
	
	@GetMapping(value="/{idPlanning}")
	@JsonView(JsonViews.Planning.class)
	public ResponseEntity<Planning>findById(@PathVariable (name="idPlanning") Integer id){
		Planning planning = planningService.showById(id);
		ResponseEntity<Planning> response = null;
		if (planning!=null) {
			response=new ResponseEntity<Planning>(planning,HttpStatus.OK);
		}else {
			response=new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return response;
	}
	
	@PutMapping(path= {"","/"})
	@JsonView(JsonViews.PlanningAvecModule.class)
	public ResponseEntity<Planning> update(@Valid @RequestBody Planning planning,BindingResult br, UriComponentsBuilder uCB){
		ResponseEntity<Planning> response = null;
		if(br.hasErrors()||planning.getIdPlanning()==null) {
			response=new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
		}else {
			Planning planningEnBase = planningService.showById(planning.getIdPlanning());
			planningEnBase.setDateDebut(planning.getDateDebut());
			planningEnBase.setDateFin(planning.getDateFin());
			planningEnBase.setGestionnaire(planning.getGestionnaire());
			planningEnBase.setMaterielPlanning(planning.getMaterielPlanning());
			planningEnBase.setModules(planning.getModules());
			planningEnBase.setSalle(planning.getSalle());
			planningEnBase.setVideoProj(planning.getVideoProj());
			planningService.updatePlanning(planningEnBase);
			response=new ResponseEntity<Planning>(planningEnBase,HttpStatus.OK);
		}
		return response;
	}
	
	@DeleteMapping(value="/{idPlanning}")
	@JsonView(JsonViews.Planning.class)
	public ResponseEntity<Void> delete(@PathVariable (name="idPlanning")Integer id){
		ResponseEntity<Void> response = null;
		Planning planning = planningService.showById(id);
		if(planning!=null) {
			planningService.deletePlanning(id);
			response=new ResponseEntity<>(HttpStatus.OK);
		}else {
			response=new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return response;
	}
	
}
