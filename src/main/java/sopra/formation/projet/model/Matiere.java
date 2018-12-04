package sopra.formation.projet.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;
import javax.validation.constraints.NotEmpty;

@Entity
@SequenceGenerator(name = "seqMatiere", sequenceName = "seq_matiere", initialValue = 1, allocationSize = 1)
public class Matiere {

	@Id
	@GeneratedValue(generator = "seqMatiere", strategy = GenerationType.SEQUENCE)
	private Integer idMatiere;
	
	@NotEmpty
	private String titre;
	
	private Integer duree;
	
	private String objectif;
	
	private String prerequis;
	
	private String contenu;
	
	@ManyToOne
	@JoinColumn(name="idModule")
	private Module module;
	
	@OneToMany(mappedBy = "key.matiere")
	private Set<FormateurMatiere> formateursMatieres;
	
	@Version
	private int version;

	public Matiere() {
	}

	public Integer getIdMatiere() {
		return idMatiere;
	}

	public void setIdMatiere(Integer idMatiere) {
		this.idMatiere = idMatiere;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Integer getDuree() {
		return duree;
	}

	public void setDuree(Integer duree) {
		this.duree = duree;
	}

	public String getObjectif() {
		return objectif;
	}

	public void setObjectif(String objectif) {
		this.objectif = objectif;
	}

	public String getPrerequis() {
		return prerequis;
	}

	public void setPrerequis(String prerequis) {
		this.prerequis = prerequis;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public Set<FormateurMatiere> getFormateursMatieres() {
		return formateursMatieres;
	}

	public void setFormateursMatieres(Set<FormateurMatiere> formateursMatieres) {
		this.formateursMatieres = formateursMatieres;
	}

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
		result = prime * result + ((idMatiere == null) ? 0 : idMatiere.hashCode());
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
		Matiere other = (Matiere) obj;
		if (idMatiere == null) {
			if (other.idMatiere != null)
				return false;
		} else if (!idMatiere.equals(other.idMatiere))
			return false;
		return true;
	}
	
}
