package sopra.formation.projet.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;
import javax.validation.constraints.NotEmpty;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type", discriminatorType=DiscriminatorType.STRING, length=10)
@SequenceGenerator(name= "seqPersonne", sequenceName="seq_person", initialValue=50, allocationSize=10)
public abstract class Personne {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqPersonne")
	private Integer id;
	@Column(name="last_name",length=200,nullable = false)
	@NotEmpty
	private String nom;
	@Column(name="first_name",length=150,nullable=false)
	@NotEmpty
	private String prenom;
	@Embedded
	@AttributeOverrides({@AttributeOverride(name= "numero", column = @Column(name = "number_person")), 
		@AttributeOverride (name= "rue", column = @Column(name = "street_person",length=100)),
		@AttributeOverride(name= "codePostal", column = @Column(name = "zip_code_person",length=20)),
		@AttributeOverride(name= "ville", column = @Column(name = "city_person", length =100)) })
	private Adresse adresse;
	@Column(name="mail")
	@NotEmpty
	private String mail;
	@Column(name="number_phone", length=10)
	@NotEmpty
	private Integer telephone;
	@Version
	private int version;
	
	public Personne() {
	}

	public Personne(Integer id, String nom, String prenom, Adresse adresse, String mail,
			 Integer telephone, int version) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.mail = mail;
		this.telephone = telephone;
		this.version = version;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}


	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Integer getTelephone() {
		return telephone;
	}

	public void setTelephone(Integer telephone) {
		this.telephone = telephone;
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
		Personne other = (Personne) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
}
