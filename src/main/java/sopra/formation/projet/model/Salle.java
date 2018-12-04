package sopra.formation.projet.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("Salle")
public class Salle extends Materiel{

	
	@Column(name = "capacite_nbSalle")
	private Integer capacite;
	
	@OneToOne
	@JoinColumn(name = "planning_salle_id")
	private Planning planning;
	
	public Salle() {
		super();
	}

	public Salle(Integer capacite) {
		super();
		this.capacite = capacite;
	}


	public Integer getCapacite() {
		return capacite;
	}

	public void setCapacite(Integer capacite) {
		this.capacite = capacite;
	}

	public Planning getPlanning() {
		return planning;
	}

	public void setPlanning(Planning planning) {
		this.planning = planning;
	}



	
}
