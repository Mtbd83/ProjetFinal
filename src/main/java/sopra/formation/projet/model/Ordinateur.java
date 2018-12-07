package sopra.formation.projet.model;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@DiscriminatorValue("Ordinateur")
public class Ordinateur extends Materiel {

	@Column(name="processeur")
	@JsonView(JsonViews.Common.class)
	private String processeur;
	
	@Column(name = "capacite_ram")
	@JsonView(JsonViews.Common.class)
	private Integer ram;
	
	@Column(name="capacite_DD")
	@JsonView(JsonViews.Common.class)
	private Integer disqueDur;
	
	@Column(name="date_achat")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonView(JsonViews.Common.class)
	private Date dateAchat;

	
	
	public Ordinateur() {
		super();
	}


	public Ordinateur(String processeur, Integer ram, Integer disqueDur, Date dateAchat) {
		super();
		this.processeur = processeur;
		this.ram = ram;
		this.disqueDur = disqueDur;
		this.dateAchat = dateAchat;
	}



	public String getProcesseur() {
		return processeur;
	}


	public void setProcesseur(String processeur) {
		this.processeur = processeur;
	}


	public Integer getRam() {
		return ram;
	}


	public void setRam(Integer ram) {
		this.ram = ram;
	}


	public Integer getDisqueDur() {
		return disqueDur;
	}


	public void setDisqueDur(Integer disqueDur) {
		this.disqueDur = disqueDur;
	}


	public Date getDateAchat() {
		return dateAchat;
	}


	public void setDateAchat(Date dateAchat) {
		this.dateAchat = dateAchat;
	}



	
	
}
