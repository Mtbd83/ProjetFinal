package sopra.formation.projet.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;

@Entity
@SequenceGenerator(name = "seqModule", sequenceName = "seq_module", initialValue = 1, allocationSize = 1)
public class Module {
	
	@Id
	@GeneratedValue(generator = "seqModule", strategy = GenerationType.SEQUENCE)
	private Integer idModule;
	
	@OneToMany(mappedBy="module")
	private Set<Matiere> matieres;
	
	@OneToMany(mappedBy="module")
	private Set<Stagiaire> stagiaires;
//	
//	@OneToOne(mappedBy="module")
//	private Planning planning;
	
	@Version
	private int version;

	public Module() {
	}

	public Integer getIdModule() {
		return idModule;
	}

	public void setIdModule(Integer idModule) {
		this.idModule = idModule;
	}

	public Set<Matiere> getMatieres() {
		return matieres;
	}

	public void setMatieres(Set<Matiere> matieres) {
		this.matieres = matieres;
	}

//	public Set<Stagiaire> getStagiaires() {
//		return stagiaires;
//	}
//
//	public void setStagiaires(Set<Stagiaire> stagiaires) {
//		this.stagiaires = stagiaires;
//	}
//
//	public Planning getPlanning() {
//		return planning;
//	}
//
//	public void setPlanning(Planning planning) {
//		this.planning = planning;
//	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idModule == null) ? 0 : idModule.hashCode());
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
		Module other = (Module) obj;
		if (idModule == null) {
			if (other.idModule != null)
				return false;
		} else if (!idModule.equals(other.idModule))
			return false;
		return true;
	}

}
