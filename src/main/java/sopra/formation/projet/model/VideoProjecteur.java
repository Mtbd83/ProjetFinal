package sopra.formation.projet.model;

import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


import com.fasterxml.jackson.annotation.JsonView;

@Entity
@DiscriminatorValue("VideoProjecteur")
public class VideoProjecteur extends Materiel {
	

	@OneToMany(mappedBy="videoProj")
	private Set<Planning> planning;

	
	public VideoProjecteur() {
		
	}

	public Set<Planning> getPlanning() {
		return planning;
	}

	public void setPlanning(Set<Planning> planning) {
		this.planning = planning;
	}


		
}
