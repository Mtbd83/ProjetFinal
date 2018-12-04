package sopra.formation.projet.model;

import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
@DiscriminatorValue("Stagiaire")
public class Stagiaire extends Personne {

	@OneToOne
	@JoinColumn(name="ordinateur")
	private Ordinateur ordinateur;
	
	@OneToMany(mappedBy="key.stagiaire")
	private Set<ModuleStagiaire> modulesStagiaires;
	
	@Enumerated(EnumType.STRING)
	private Profil profil;

	public Stagiaire() {
	}

	public Ordinateur getOrdinateur() {
		return ordinateur;
	}

	public void setOrdinateur(Ordinateur ordinateur) {
		this.ordinateur = ordinateur;
	}

	public Set<ModuleStagiaire> getModulesStagiaires() {
		return modulesStagiaires;
	}

	public void setModulesStagiaires(Set<ModuleStagiaire> modulesStagiaires) {
		this.modulesStagiaires = modulesStagiaires;
	}

	public Profil getProfil() {
		return profil;
	}

	public void setProfil(Profil profil) {
		this.profil = profil;
	}
	
}
