package sopra.formation.projet.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@DiscriminatorValue("Salle")
public class Salle extends Materiel{

	@JsonView(JsonViews.Common.class)
	@Column(name = "capacite_nbSalle")
	private Integer capacite;
	
	@JsonView(JsonViews.SalleAvecPlanning.class)
	@OneToMany(mappedBy="salle")
	private Set<Planning> planning;
	
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

	public Set<Planning> getPlanning() {
		return planning;
	}

	public void setPlanning(Set<Planning> planning) {
		this.planning = planning;
	}





	
}
