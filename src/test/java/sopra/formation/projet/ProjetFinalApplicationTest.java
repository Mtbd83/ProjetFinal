package sopra.formation.projet;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import sopra.formation.projet.model.Formateur;
import sopra.formation.projet.model.Matiere;
import sopra.formation.projet.repository.MatiereRepository;
import sopra.formation.projet.service.FormateurMatiereService;
import sopra.formation.projet.service.FormateurService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjetFinalApplicationTest {

	@Test
    public void contextLoads() {
    }
	
	@Autowired
	private FormateurService formateurService;
	
	@Autowired
	private MatiereRepository matiereRepo;
	
	@Autowired
	private FormateurMatiereService formateurMatiereService;
	
	//@Test
	public void testCreerFormateur() {
		Formateur formateur = new Formateur();
		formateur.setNom("Aa");
		formateur.setPrenom("Aa");
		formateurService.creerFormateur(formateur);
	}
	
	//@Test
		public void deleteFormateur() {
			Formateur formateur = formateurService.showFormateurByNom("Aa");
			formateurService.deleteFormateur(formateur);
		}
		
	//@Test
	public void testAjoutMatiere() {
		Formateur formateur = formateurService.showFormateurByNom("Aa");
		Optional<Matiere> opt = matiereRepo.findById(4);
		Matiere matiere = opt.get();
		formateurService.ajoutMatiere(formateur, matiere);
	}
	
	//@Test
	public void listeByMatiere() {
		Optional<Matiere> opt = matiereRepo.findById(4);
		Matiere matiere = opt.get();
		List<Formateur> f = formateurService.listeFormateurParMatiere(matiere);
		System.out.println(f.toString());
	}
	
	//@Test
	public void testcreerFM() {
		Formateur formateur = formateurService.showFormateurByNom("Aa");
		Matiere matiere = new Matiere();
		matiere.setTitre("java");
		matiereRepo.save(matiere);
		formateurMatiereService.creerFormateurMatiere(formateur, matiere);
	}
	
	//@Test
	public void testListeFM() {
		formateurMatiereService.findAllFormateurMatiere();
	}
	
}
