package sopra.formation.projet.model;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import sopra.formation.projet.model.Personne;


@Entity
@DiscriminatorValue("Technicien")
public class Technicien extends Personne{

	@Column(name="logistique")
	private String logistique;
	
	@OneToOne
	@JoinColumn(name="login")
	private Login login;
	
	@OneToOne
	@JoinColumn(name="planning")
	private Planning planning;
	
	public Technicien() {
		
	}

	public Technicien(String logistique, Login login, Planning planning) {
		this.logistique = logistique;
		this.login = login;
		this.planning = planning;
	}

	public String getLogistique() {
		return logistique;
	}

	public void setLogistique(String logistique) {
		this.logistique = logistique;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public Planning getPlanning() {
		return planning;
	}

	public void setPlanning(Planning planning) {
		this.planning = planning;
	}
}
