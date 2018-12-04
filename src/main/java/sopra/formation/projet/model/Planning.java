package sopra.formation.projet.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="planning")
@SequenceGenerator(name="seqIdPlanning",sequenceName="seq_id_planning", initialValue=1,allocationSize=1)
public class Planning {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqIdPlanning") 
	private Integer idPlanning;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dateDebut;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dateFin;
	
	
	@OneToOne
	@JoinColumn(name = "gestionnaire")
	private Gestionnaire gestionnaire;
		
	@OneToOne
	@JoinColumn(name = "ordinateur")
	private Ordinateur ordi;
	
	
	@OneToOne
	@JoinColumn(name = "videoprojecteur")
	private VideoProjecteur videoProj;
	
	@OneToMany(mappedBy="planning")
	private Set<Module> modules;
	
	
	@OneToOne
	@JoinColumn(name = "salle")
	private Salle salle;
	
	@Version
	private int version;
	
	
	
	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Planning() {
		
	}

	public Integer getIdPlanning() {
		return idPlanning;
	}

	public void setIdPlanning(Integer idPlanning) {
		this.idPlanning = idPlanning;
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

	public Gestionnaire getGestionnaire() {
		return gestionnaire;
	}

	public void setGestionnaire(Gestionnaire gestionnaire) {
		this.gestionnaire = gestionnaire;
	}

	public Ordinateur getOrdi() {
		return ordi;
	}

	public void setOrdi(Ordinateur ordi) {
		this.ordi = ordi;
	}

	public VideoProjecteur getVideoProj() {
		return videoProj;
	}

	public void setVideoProj(VideoProjecteur videoProj) {
		this.videoProj = videoProj;
	}



	public Set<Module> getModules() {
		return modules;
	}

	public void setModules(Set<Module> modules) {
		this.modules = modules;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPlanning == null) ? 0 : idPlanning.hashCode());
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
		Planning other = (Planning) obj;
		if (idPlanning == null) {
			if (other.idPlanning != null)
				return false;
		} else if (!idPlanning.equals(other.idPlanning))
			return false;
		return true;
	}
	
	
	
	

}
