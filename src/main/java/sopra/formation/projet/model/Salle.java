package sopra.formation.projet.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Salle")
public class Salle extends Materiel{

	
	@Column(name = "capacite_nbSalle")
	private Integer capacite;
	
	public Salle() {
		super();
	}

	public Salle(Integer capacite) {
		super();
		this.capacite = capacite;
	}


	public Integer getNbStagaire() {
		return capacite;
	}

	public void setNbStagaire(Integer nbStagaire) {
		this.capacite = nbStagaire;
	}

}
