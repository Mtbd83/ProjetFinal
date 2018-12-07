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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonView;

import sopra.formation.projet.model.FormateurMatiere;
import sopra.formation.projet.model.FormateurMatiereKey;
import sopra.formation.projet.model.JsonViews;
import sopra.formation.projet.service.FormateurMatiereService;

@RestController
@RequestMapping("/rest/formateurmatiere")
@CrossOrigin(origins = {"*"})
public class FormateurMatiereRestController {

	@Autowired
	private FormateurMatiereService formateurMatiereService;
	
	@GetMapping(path= { "" , "/" })
	@JsonView(JsonViews.FormateurMatiere.class)
	public ResponseEntity<List<FormateurMatiere>> findAll(){
		return new ResponseEntity<>(formateurMatiereService.findAllFormateurMatiere(), HttpStatus.OK);
	}
	
	@PostMapping(path= { "" , "/" })
	@JsonView(JsonViews.FormateurMatiere.class)
	public ResponseEntity<Void> createFormateurMatiere(@Valid @RequestBody FormateurMatiere formateurMatiere, BindingResult result, UriComponentsBuilder uCB){
		ResponseEntity<Void> response = null;
		if(result.hasErrors()) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			formateurMatiereService.creerFormateurMatiere(formateurMatiere.getKey().getFormateur(), formateurMatiere.getKey().getMatiere());
			HttpHeaders header = new HttpHeaders();
			header.setLocation(uCB.path("/rest/formateurmatiere/{key}").buildAndExpand(formateurMatiere.getKey()).toUri());
			response = new ResponseEntity<>(header, HttpStatus.CREATED);
		}
		return response;
	}
	
	@GetMapping(value="/{key}")
	@JsonView(JsonViews.FormateurMatiere.class)
	public ResponseEntity<FormateurMatiere> findById(@PathVariable(name="key") FormateurMatiereKey key) {
		FormateurMatiere formateurMatiere = formateurMatiereService.findOne(key);
		ResponseEntity<FormateurMatiere> response = null;
		if(formateurMatiere != null) {
			response = new ResponseEntity<FormateurMatiere>(formateurMatiere, HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return response;
	}
	
	@DeleteMapping(value="/{key}")
	public ResponseEntity<Void> delete(@PathVariable(name="key") FormateurMatiereKey key){
		FormateurMatiere formateurMatiere = formateurMatiereService.findOne(key);
		ResponseEntity<Void> response = null;
		if(formateurMatiere != null) {
			formateurMatiereService.deleteFormateurMatiere(formateurMatiere);
			response = new ResponseEntity<>(HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return response;
	}
}
