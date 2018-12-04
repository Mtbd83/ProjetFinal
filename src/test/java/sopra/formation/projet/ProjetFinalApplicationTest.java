package sopra.formation.projet;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import sopra.formation.projet.model.Formateur;
import sopra.formation.projet.model.Module;
import sopra.formation.projet.service.ModuleService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjetFinalApplicationTest {
	
	@Test
	public void contextLoads() {
	}
	
	@Autowired
	private ModuleService moduleService;
	
	
	public void create() {
		Module module = new Module();
		moduleService.createModule(module);
		assertNotNull(moduleService.showAll());
		
	}
	
	@Test
	public void delete() {
		moduleService.deleteModule(1);
		assertNull(moduleService.showById(1));
		
	}

	

}
