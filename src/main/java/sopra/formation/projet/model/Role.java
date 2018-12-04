package sopra.formation.projet.model;

public enum Role {
	ADMIN("Admin"), GEST("Gestionnaire"), FORM("Formateur"), TECH("Technicien"), STAG("Stagiaire");
	
	private String role;
	
	private Role(String role) {
		this.role=role;
	}
	
	public String getRole() {
		return role;
	}
	

}
