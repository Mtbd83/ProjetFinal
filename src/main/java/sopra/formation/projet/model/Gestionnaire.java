package sopra.formation.projet.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("Gestionnaire")
public class Gestionnaire extends Personne{
	
	@Column(name="dossierAdmn")
	private String dossierAdm;
	
//	@OneToOne
//	@JoinColumn(name="planning")
//	private Planning planning;
	
	@OneToOne
	@JoinColumn(name="login")
	private Login login;

	public Gestionnaire() {
		
	}

	public Gestionnaire(String dossierAdm,  Login login) {
		this.dossierAdm = dossierAdm;
		//this.planning = planning;
		this.login = login;
	}

	public String getDossierAdm() {
		return dossierAdm;
	}

	public void setDossierAdm(String dossierAdm) {
		this.dossierAdm = dossierAdm;
	}

//	public Planning getPlanning() {
//		return planning;
//	}
//
//	public void setPlanning(Planning planning) {
//		this.planning = planning;
//	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
}
