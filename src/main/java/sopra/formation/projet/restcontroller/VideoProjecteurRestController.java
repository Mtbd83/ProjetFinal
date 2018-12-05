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

import sopra.formation.projet.model.VideoProjecteur;
import sopra.formation.projet.service.VideoProjecteurService;

@RestController
@RequestMapping("/rest/materiel/videoprojecteur")
@CrossOrigin(origins = {"*"})
public class VideoProjecteurRestController {

	@Autowired
	private VideoProjecteurService videoProjecteurService;
	
	@GetMapping(path= { "" , "/" })
	public ResponseEntity<List<VideoProjecteur>> findAllVideoProjecteur(){
		return new ResponseEntity<>(videoProjecteurService.showAllVideoProjecteur(), HttpStatus.OK);
	}
	
	@PostMapping(path= { "" , "/" })
	public ResponseEntity<Void> createVideoProjecteur(@Valid @RequestBody VideoProjecteur videoProjecteur, BindingResult result, UriComponentsBuilder uCB){
		ResponseEntity<Void> response = null;
		if(result.hasErrors()) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			videoProjecteurService.createVideoProjecteur(videoProjecteur);
			HttpHeaders header = new HttpHeaders();
			header.setLocation(uCB.path("/rest/materiel/videoProjecteur/{id}").buildAndExpand(videoProjecteur.getId()).toUri());
			response = new ResponseEntity<>(header, HttpStatus.CREATED);
		}
		return response;
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<VideoProjecteur> findById(@PathVariable(name="id") Integer id) {
		VideoProjecteur videoProjecteur = videoProjecteurService.showVideoProjecteurById(id);
		ResponseEntity<VideoProjecteur> response = null;
		if(videoProjecteur != null) {
			response = new ResponseEntity<VideoProjecteur>(videoProjecteur, HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return response;
	}
	
	@PutMapping(path= { "" , "/" })
	public ResponseEntity<VideoProjecteur> update(@Valid @RequestBody VideoProjecteur videoProjecteur, BindingResult result){
		ResponseEntity<VideoProjecteur> response = null;
		if(result.hasErrors() || videoProjecteur.getId() == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
		} else {
			VideoProjecteur videoProjecteurEnBase = videoProjecteurService.showVideoProjecteurById(videoProjecteur.getId());
			videoProjecteurEnBase.setCode(videoProjecteur.getCode());
			videoProjecteurEnBase.setCout(videoProjecteur.getCout());
			videoProjecteurEnBase.setDisponibilité(videoProjecteur.isDisponibilité());
			videoProjecteurEnBase.setMaterielPlanning(videoProjecteur.getMaterielPlanning());
			videoProjecteurEnBase.setPlanning(videoProjecteur.getPlanning());
			videoProjecteurService.update(videoProjecteurEnBase);
			response = new ResponseEntity<VideoProjecteur>(videoProjecteurEnBase, HttpStatus.OK);
		}
		return response;
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable(name="id") Integer id){
		VideoProjecteur videoProjecteur = videoProjecteurService.showVideoProjecteurById(id);
		ResponseEntity<Void> response = null;
		if(videoProjecteur != null) {
			videoProjecteurService.deleteVideoProjecteur(videoProjecteur);
			response = new ResponseEntity<>(HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return response;
	}
}
