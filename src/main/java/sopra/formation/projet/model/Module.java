package sopra.formation.projet.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@SequenceGenerator(name = "seqModule", sequenceName = "seq_module", initialValue = 1, allocationSize = 1)
public class Module {
	
	@Id
	@GeneratedValue(generator = "seqModule", strategy = GenerationType.SEQUENCE)
	@JsonView(JsonViews.Common.class)
	private Integer idModule;
	
	@JsonView(JsonViews.Common.class)
	@OneToOne(mappedBy="module")
	private Matiere matiere;
	
	@JsonView(JsonViews.Common.class)
	@ManyToOne
	@JoinColumn(name="formateur_id")
	private Formateur formateur;
	
	@JsonView(JsonViews.Common.class)
	@OneToMany(mappedBy="key.module")
	private Set<ModuleStagiaire> modulesStagiaires;

	@JsonView(JsonViews.Common.class)
	@ManyToOne
	@JoinColumn(name="planning_id")
	private Planning planning;
	
	@JsonView(JsonViews.Common.class)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dateDebut;
	
	@JsonView(JsonViews.Common.class)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dateFin;
	

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

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public Set<ModuleStagiaire> getModulesStagiaires() {
		return modulesStagiaires;
	}

	public void setModulesStagiaires(Set<ModuleStagiaire> modulesStagiaires) {
		this.modulesStagiaires = modulesStagiaires;
	}

	public Formateur getFormateur() {
		return formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}

	public Planning getPlanning() {
		return planning;
	}

	public void setPlanning(Planning planning) {
		this.planning = planning;
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
