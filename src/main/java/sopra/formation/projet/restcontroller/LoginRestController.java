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
import sopra.formation.projet.model.Login;
import sopra.formation.projet.service.LoginService;

@RestController
@RequestMapping("/rest/user")
@CrossOrigin(origins = { "*" })
public class LoginRestController {

	@Autowired
	private LoginService loginService;

	@GetMapping(path = { "", "/" })
	@JsonView(JsonViews.Common.class)
	public ResponseEntity<List<Login>> findAllLogin() {
		return new ResponseEntity<>(loginService.showAllLogin(), HttpStatus.OK);
	}

	@GetMapping(path = {"/{username}" })
	@JsonView(JsonViews.LoginAvecRole.class)
	public ResponseEntity<Login> findLoginById(@PathVariable(name = "username") String username) {
		Login login = loginService.showLoginByUsername(username);
		ResponseEntity<Login> response = null;
		if (login != null) {
			response = new ResponseEntity<Login>(login,HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return response;
	}

	@PostMapping(path = { "", "/" })
	@JsonView(JsonViews.Common.class)
	public ResponseEntity<Void> createLogin(@Valid @RequestBody Login login, BindingResult result,
			UriComponentsBuilder uCB) {
		ResponseEntity<Void> response = null;
		if (result.hasErrors()) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			loginService.CreateLogin(login);
			HttpHeaders header = new HttpHeaders();
			header.setLocation(uCB.path("/rest/user/{id}").buildAndExpand(login.getUsername()).toUri());
			response = new ResponseEntity<>(header, HttpStatus.CREATED);
		}
		return response;
	}

	@PutMapping(path = { "", "/" })
	@JsonView(JsonViews.Common.class)
	public ResponseEntity<Login> update(@Valid @RequestBody Login login, BindingResult result) {
		ResponseEntity<Login> response = null;
		if (result.hasErrors() || login.getUsername() == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
		} else {
			Login loginEnBase = loginService.showLoginByUsername(login.getUsername());
			loginEnBase.setUsername(login.getUsername());
			loginEnBase.setPassword(login.getPassword());
			loginEnBase.setRoles(login.getRoles());
			loginService.update(loginEnBase);
			response = new ResponseEntity<Login>(loginEnBase, HttpStatus.OK);
		}
		return response;
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable(name = "username") String username) {
		Login login = loginService.showLoginByUsername(username);
		ResponseEntity<Void> response = null;
		if (login != null) {
			loginService.EraseLogin(login);
			response = new ResponseEntity<>(HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return response;
	}
}
