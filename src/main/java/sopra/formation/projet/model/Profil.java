package sopra.formation.projet.model;

public enum Profil {

	D("Débutant"), A("Avancé"), I("Intermédiaire"), E("Expert");
	
	private String niveau;

	private Profil(String niveau) {
		this.niveau = niveau;
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}
	
}
