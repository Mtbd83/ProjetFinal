package sopra.formation.projet.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonView;

@Embeddable
public class Adresse {
	
	@Column(name="numero",length=20)
	@JsonView(JsonViews.Common.class)
	private Integer numero;
	@Column(name="rue", length=100)
	@JsonView(JsonViews.Common.class)
	private String rue;
	@Column(name="ville",length=100)
	@JsonView(JsonViews.Common.class)
	private String ville;
	@Column(name="codePostal",length=20)
	@JsonView(JsonViews.Common.class)
	private String codePostal;
	
	
	public Adresse() {
	}

	public Adresse(Integer numero, String rue, String ville, String codePostal, int version) {
		this.numero = numero;
		this.rue = rue;
		this.ville = ville;
		this.codePostal = codePostal;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
}
