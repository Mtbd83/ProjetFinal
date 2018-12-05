package sopra.formation.projet;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import sopra.formation.projet.model.Materiel;
import sopra.formation.projet.model.Ordinateur;
import sopra.formation.projet.service.MaterielService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjetFinalApplicationTest {

	@Test
	public void contextLoads() {
	}


	@Autowired
	private MaterielService materielService;

//	@Test
	public void create() {
		Materiel materiel = new Ordinateur();
		materielService.createMateriel(materiel);
		assertNotNull(materielService.showAll());
	}
	
//	@Test
	public void delete() {
		materielService.deleteMateriel(1);
		assertNull(materielService.showMateriel(1));
	}

}
