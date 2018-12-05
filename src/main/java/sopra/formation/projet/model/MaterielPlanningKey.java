package sopra.formation.projet.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Embeddable
public class MaterielPlanningKey implements Serializable {

	@ManyToOne
	@JoinColumn(name = "idMateriel")
	private Materiel materiel;

	@ManyToOne
	@JoinColumn(name = "idPlanning")
	private Planning planning;

	public MaterielPlanningKey() {
		super();
	}

	public MaterielPlanningKey(Materiel materiel, Planning planning) {
		super();
		this.materiel = materiel;
		this.planning = planning;
	}

	public Materiel getMateriel() {
		return materiel;
	}

	public void setMateriel(Materiel materiel) {
		this.materiel = materiel;
	}

	public Planning getPlanning() {
		return planning;
	}

	public void setPlanning(Planning planning) {
		this.planning = planning;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((materiel == null) ? 0 : materiel.hashCode());
		result = prime * result + ((planning == null) ? 0 : planning.hashCode());
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
		MaterielPlanningKey other = (MaterielPlanningKey) obj;
		if (materiel == null) {
			if (other.materiel != null)
				return false;
		} else if (!materiel.equals(other.materiel))
			return false;
		if (planning == null) {
			if (other.planning != null)
				return false;
		} else if (!planning.equals(other.planning))
			return false;
		return true;
	}

}
