package sopra.formation.projet.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class ModuleStagiaire {

	@EmbeddedId
	private ModuleStagiaireKey key;

	public ModuleStagiaire() {
	}

	public ModuleStagiaireKey getKey() {
		return key;
	}

	public void setKey(ModuleStagiaireKey key) {
		this.key = key;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
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
		ModuleStagiaire other = (ModuleStagiaire) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}
	
}
