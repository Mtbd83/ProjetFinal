package sopra.formation.projet.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Embeddable
public class ModuleStagiaireKey implements Serializable {

	@ManyToOne
	@JoinColumn(name = "idModule")
	private Module module;
	
	@ManyToOne
	@JoinColumn(name = "idStagiaire")
	private Stagiaire stagiaire;
	
	public ModuleStagiaireKey() {
	}

	public ModuleStagiaireKey(Module module, Stagiaire stagiaire) {
		this.module = module;
		this.stagiaire = stagiaire;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public Stagiaire getStagiaire() {
		return stagiaire;
	}

	public void setStagiaire(Stagiaire stagiaire) {
		this.stagiaire = stagiaire;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((module == null) ? 0 : module.hashCode());
		result = prime * result + ((stagiaire == null) ? 0 : stagiaire.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ModuleStagiaireKey other = (ModuleStagiaireKey) obj;
		if (module == null) {
			if (other.module != null)
				return false;
		} else if (!module.equals(other.module))
			return false;
		if (stagiaire == null) {
			if (other.stagiaire != null)
				return false;
		} else if (!stagiaire.equals(other.stagiaire))
			return false;
		return true;
	}
	
}
