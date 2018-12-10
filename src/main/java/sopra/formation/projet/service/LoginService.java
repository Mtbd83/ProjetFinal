package sopra.formation.projet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sopra.formation.projet.model.Login;
import sopra.formation.projet.model.Salle;
import sopra.formation.projet.repository.LoginRepository;

@Service
public class LoginService {

	@Autowired
	private LoginRepository loginRepository;

	public void CreateLogin(Login login) {
		loginRepository.save(login);
	}

	public void changeLogin(String oldLogin, String newLogin) {
		Optional<Login> opt = loginRepository.findWithUsername(oldLogin);
		if (opt.isPresent()) {
			Login login = opt.get();
			login.setUsername(newLogin);
			loginRepository.save(login);
		}
	}
	
	public void changePassword(String oldPassword, String newPassword) {
		Optional<Login> opt = loginRepository.findWithPassword(oldPassword);
		if (opt.isPresent()) {
			Login login = opt.get();
			login.setPassword(newPassword);;
			loginRepository.save(login);
		}
	}
	
	public void update(Login login) {
		Optional<Login> opt = loginRepository.findById(login.getUsername());
		Login l = new Login();
		if(opt.isPresent()) {
			l = opt.get();
			loginRepository.save(l);
		}
	}
	
	public String showLogin(String username) {
		Optional<Login> opt = loginRepository.findWithUsername(username);
		if (opt.isPresent()) {
			Login log = opt.get();
			return log.getUsername();
		} else {
			return "pas de login, désolé !";
		}
	}
	
	public Login showLoginByUsername(String username) {
		Optional<Login> opt = loginRepository.findByIdWithRoles(username);
		Login login = null;
		if(opt.isPresent()) {
			login = opt.get();
		}
		return login;
	}
	

	public String showMdp(String password) {
		Optional<Login> opt = loginRepository.findWithPassword(password);
		if (opt.isPresent()) {
			Login log = opt.get();
			return log.getPassword();
		} else {
			return "pas de password, désolé !";
		}
	}

	public void EraseLogin(Login login) {
		loginRepository.delete(login);
	}

	public List<Login> showAllLogin() {
		return loginRepository.findAll();
	}

	


}
