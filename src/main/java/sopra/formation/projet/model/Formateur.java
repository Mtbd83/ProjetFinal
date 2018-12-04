package sopra.formation.projet.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("Formateur")
public class Formateur extends Personne{
	
	@OneToMany(mappedBy="key.formateur")
	@Column(name="matiere")
	private Set<FormateurMatiere> formateurmatiere;
	@OneToOne(mappedBy="formateur")
	@Column(name="login")
	private Login login;

	
	public Formateur() {
		
	}		

	public Formateur(Set<FormateurMatiere> formateurmatiere, Login login) {
		this.formateurmatiere = formateurmatiere;
		this.login = login;
	}

	public Set<FormateurMatiere> getFormateurmatiere() {
		return formateurmatiere;
	}

	public void setFormateurmatiere(Set<FormateurMatiere> formateurmatiere) {
		this.formateurmatiere = formateurmatiere;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
}
