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

import sopra.formation.projet.model.Formateur;
import sopra.formation.projet.model.JsonViews;
import sopra.formation.projet.model.Matiere;
import sopra.formation.projet.service.FormateurMatiereService;
import sopra.formation.projet.service.FormateurService;
import sopra.formation.projet.service.MatiereService;

@RestController
@RequestMapping("/rest/formateur")
@CrossOrigin(origins = {"*"})
public class FormateurRestController {

	@Autowired
	private FormateurService formateurService;
	
	@Autowired
	private FormateurMatiereService formateurMatiereService;
	
	@Autowired
	private MatiereService matiereService;
	
	@GetMapping(path= { "" , "/" })
	@JsonView(JsonViews.Common.class)
	public ResponseEntity<List<Formateur>> findAll(){
		return new ResponseEntity<>(formateurService.listeFormateurs(), HttpStatus.OK);
	}
	
	@GetMapping(path= { "/matiere" })
	@JsonView(JsonViews.FormateurAvecMatiere.class)
	public ResponseEntity<List<Formateur>> findAllWithMatiere(){
		return new ResponseEntity<>(formateurService.listeFormateurAvecMatiere(), HttpStatus.OK);
	}
	
	@GetMapping(path={ "/matiere/{id}" })
	@JsonView(JsonViews.FormateurAvecMatiere.class)
	public ResponseEntity<List<Matiere>> findWithMatiere(@PathVariable(name="id") Integer id){
		return new ResponseEntity<List<Matiere>>(formateurService.formateurAvecMatiere(id), HttpStatus.OK);
	}
	
	@PostMapping(path= { "" , "/" })
	@JsonView(JsonViews.Common.class)
	public ResponseEntity<Void> createFormateur(@Valid @RequestBody Formateur formateur, BindingResult result, UriComponentsBuilder uCB){
		ResponseEntity<Void> response = null;
		if(result.hasErrors()) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			formateurService.creerFormateur(formateur);
			HttpHeaders header = new HttpHeaders();
			header.setLocation(uCB.path("/rest/formateur/{id}").buildAndExpand(formateur.getId()).toUri());
			response = new ResponseEntity<>(header, HttpStatus.CREATED);
		}
		return response;
	}
	
	@GetMapping(value="/{id}")
	@JsonView(JsonViews.Common.class)
	public ResponseEntity<Formateur> findById(@PathVariable(name="id") Integer id) {
		Formateur formateur = formateurService.showFormateurById(id);
		ResponseEntity<Formateur> response = null;
		if(formateur != null) {
			response = new ResponseEntity<Formateur>(formateur, HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return response;
	}
	
	@PutMapping(path= { "" , "/" })
	@JsonView(JsonViews.Common.class)
	public ResponseEntity<Formateur> update(@Valid @RequestBody Formateur formateur, BindingResult result){
		ResponseEntity<Formateur> response = null;
		if(result.hasErrors() || formateur.getId() == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
		} else {
			Formateur formateurEnBase = formateurService.showFormateurById(formateur.getId());
			formateurEnBase.setNom(formateur.getNom());
			formateurEnBase.setPrenom(formateur.getPrenom());
			formateurEnBase.setTelephone(formateur.getTelephone());
			formateurEnBase.setMail(formateur.getMail());
			formateurEnBase.setAdresse(formateur.getAdresse());
			formateurService.modifFormateur(formateurEnBase);
			response = new ResponseEntity<Formateur>(formateurEnBase, HttpStatus.OK);
		}
		return response;
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable(name="id") Integer id){
		Formateur formateur = formateurService.showFormateurById(id);
		ResponseEntity<Void> response = null;
		if(formateur != null) {
			formateurService.deleteFormateur(formateur);
			response = new ResponseEntity<>(HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return response;
	}
	
	@DeleteMapping(value="/matiere/{id}/{idMatiere}")
	public ResponseEntity<Void> deleteMatiereFormateur(@PathVariable(name="id") Integer id, @PathVariable(name="idMatiere") Integer idMatiere){
		Matiere ma = matiereService.findMatiere(idMatiere);
		ResponseEntity<Void> response = null;
		if(ma != null) {
			formateurMatiereService.deleteFormateurMatiereByMatiere(ma);
			response = new ResponseEntity<>(HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return response;
	}
}
