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
import sopra.formation.projet.model.Matiere;
import sopra.formation.projet.service.MatiereService;


@RestController
@RequestMapping("/rest/matiere")
@CrossOrigin(origins = {"*"})
public class MatiereRestController {
	
	@Autowired
	private MatiereService matiereService;

	@GetMapping(path = { "", "/" })
	@JsonView(JsonViews.Common.class)
	public ResponseEntity<List<Matiere>> findAll() {
		return new ResponseEntity<>(matiereService.findAll(), HttpStatus.OK);
	}

	@PostMapping(path = { "", "/" })
	@JsonView(JsonViews.Common.class)
	public ResponseEntity<Void> createMatiere(@Valid @RequestBody Matiere matiere, BindingResult br,
			UriComponentsBuilder uCB) {
		ResponseEntity<Void> response = null;
		if (br.hasErrors()) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			matiereService.createMatiere(matiere);
			HttpHeaders header = new HttpHeaders();
			header.setLocation(uCB.path("/rest/matiere/{id}").buildAndExpand(matiere.getIdMatiere()).toUri());
			response = new ResponseEntity<>(header, HttpStatus.CREATED);
		}
		return response;
	}

	@GetMapping(value = "/{idMatiere}")
	@JsonView(JsonViews.Common.class)
	public ResponseEntity<Matiere> findById(@PathVariable(name = "idMatiere") Integer idMatiere) {
		Matiere opt = matiereService.findMatiere(idMatiere);
		ResponseEntity<Matiere> response = null;
		if (opt!=null) {
			response = new ResponseEntity<Matiere>(opt, HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return response;
	}
	
	@DeleteMapping(value = "/{idMatiere}")
	@JsonView(JsonViews.Common.class)
	public ResponseEntity<Void> delete(@PathVariable(name = "idMatiere") Integer idMatiere) {
		Matiere opt = matiereService.findMatiere(idMatiere);
		ResponseEntity<Void> response = null;
		if(opt!=null) {
			matiereService.deleteMatiere(opt);
			response = new ResponseEntity<>(HttpStatus.OK);
		}else {
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return response;
	}
	
	@PutMapping(path = { "", "/" })
	@JsonView(JsonViews.Common.class)
	public ResponseEntity<Matiere> update(@Valid @RequestBody Matiere matiere, BindingResult br) {
		ResponseEntity<Matiere> response = null;
		if (br.hasErrors() || matiere.getIdMatiere() == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
		} else {
				Matiere matiereEnBase = matiereService.findMatiere(matiere.getIdMatiere());
				matiereEnBase.setTitre(matiere.getTitre());
				matiereEnBase.setDuree(matiere.getDuree());
				matiereEnBase.setObjectif(matiere.getObjectif());
				matiereEnBase.setPrerequis(matiere.getPrerequis());
				matiereEnBase.setContenu(matiere.getContenu());
				matiereEnBase.setModule(matiere.getModule());
				matiereEnBase.setFormateursMatieres(matiere.getFormateursMatieres());
				matiereService.update(matiereEnBase);
				response = new ResponseEntity<Matiere>(matiereEnBase, HttpStatus.OK);	
		}
		return response;
	}
}
