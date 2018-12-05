package sopra.formation.projet.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class MaterielPlanning {

	@EmbeddedId
	private MaterielPlanningKey key;

	private boolean disponibilite;

	public MaterielPlanning() {
	}

	public MaterielPlanning(MaterielPlanningKey key, boolean disponibilite) {
		super();
		this.key = key;
		this.disponibilite = disponibilite;
	}

	public MaterielPlanningKey getKey() {
		return key;
	}

	public void setKey(MaterielPlanningKey key) {
		this.key = key;
	}

	public boolean isDisponibilite() {
		return disponibilite;
	}

	public void setDisponibilite(boolean disponibilite) {
		this.disponibilite = disponibilite;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (disponibilite ? 1231 : 1237);
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
		MaterielPlanning other = (MaterielPlanning) obj;
		if (disponibilite != other.disponibilite)
			return false;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}

}
