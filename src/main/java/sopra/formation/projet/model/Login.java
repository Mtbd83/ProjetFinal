package sopra.formation.projet.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Login {
	
	@Id
	private String username;
	private String password;
	private boolean enable;
	@OneToMany(mappedBy="user")
	private Set<LoginRole> roles;
	
	public Login() {
		
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnable() {
		return enable;
	}
	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public Set<LoginRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<LoginRole> roles) {
		this.roles = roles;
	}
	
	
	
	
}
