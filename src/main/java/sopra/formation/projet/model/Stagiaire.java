package sopra.formation.projet.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("Stagiaire")
public class Stagiaire extends Personne {

	@OneToOne
	@JoinColumn(name="ordinateur")
	private Ordinateur ordinateur;
	
	@ManyToOne
	@JoinColumn(name="module")
	private Module module;
	
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

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public Profil getProfil() {
		return profil;
	}

	public void setProfil(Profil profil) {
		this.profil = profil;
	}
	
}
