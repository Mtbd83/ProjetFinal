package sopra.formation.projet.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "materiel")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@SequenceGenerator(name = "seqMateriel", sequenceName = "seq_materiel", initialValue = 50, allocationSize = 20)
public abstract class Materiel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqMateriel")
	@JsonView(JsonViews.Common.class)
	private Integer id;
	@Column(name = "code", length = 100)
	@JsonView(JsonViews.Common.class)
	private Integer code;
	@Column(name = "cout", length = 100)
	@JsonView(JsonViews.Common.class)
	private Integer cout;
	@Column(name = "disponibilite", length = 100)
	@JsonView(JsonViews.Common.class)
	private boolean disponibilite;
	@Version
	private int version;
	
	@JsonView(JsonViews.MaterielAvecMaterielPlanning.class)
	@OneToMany(mappedBy = "key.materiel")
	private Set<MaterielPlanning> materielPlanning;
	
	public Materiel() {
		
	}

	public Materiel(Integer code, Integer cout, boolean disponibilite) {
		super();
		this.code = code;
		this.cout = cout;
		this.disponibilite = disponibilite;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Integer getCout() {
		return cout;
	}

	public void setCout(Integer cout) {
		this.cout = cout;
	}

	public boolean isDisponibilite() {
		return disponibilite;
	}

	public void setDisponibilite(boolean disponibilite) {
		this.disponibilite = disponibilite;
	}

	public Set<MaterielPlanning> getMaterielPlanning() {
		return materielPlanning;
	}

	public void setMaterielPlanning(Set<MaterielPlanning> materielPlanning) {
		this.materielPlanning = materielPlanning;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Materiel other = (Materiel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
	
	
}
