package sopra.formation.projet.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("VideoProjecteur")
public class VideoProjecteur extends Materiel {
	
	@OneToOne
	@JoinColumn(name = "planning_id")
	private Planning planning;
	
	public VideoProjecteur() {
		
	}

	public Planning getPlanning() {
		return planning;
	}

	public void setPlanning(Planning planning) {
		this.planning = planning;
	}
	
		
}
