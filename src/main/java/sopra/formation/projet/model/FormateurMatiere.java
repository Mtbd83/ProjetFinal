package sopra.formation.projet.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class FormateurMatiere {

	@EmbeddedId
	@JsonView(JsonViews.Common.class)
	private FormateurMatiereKey key;
	
	@JsonView(JsonViews.Common.class)
	private String expertise;

	public FormateurMatiere() {
	}

	public FormateurMatiereKey getKey() {
		return key;
	}

	public void setKey(FormateurMatiereKey key) {
		this.key = key;
	}

	public String getExpertise() {
		return expertise;
	}

	public void setExpertise(String expertise) {
		this.expertise = expertise;
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
		FormateurMatiere other = (FormateurMatiere) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}

}
