package sopra.formation.projet.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@DiscriminatorValue("Salle")
public class Salle extends Materiel{

	@JsonView(JsonViews.Common.class)
	@Column(name = "capacite_nbSalle")
	private Integer capacite;
	
	@OneToOne
	@JoinColumn(name = "planning_salle_id")
	@JsonView(JsonViews.SalleAvecPlanning.class)
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
