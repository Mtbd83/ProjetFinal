package sopra.formation.projet.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@DiscriminatorValue("VideoProjecteur")
public class VideoProjecteur extends Materiel {
	
	@OneToOne
	@JoinColumn(name = "planning_id")
	@JsonView(JsonViews.Common.class)
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
