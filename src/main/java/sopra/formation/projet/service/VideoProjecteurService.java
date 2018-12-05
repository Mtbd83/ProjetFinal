package sopra.formation.projet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import sopra.formation.projet.model.VideoProjecteur;
import sopra.formation.projet.repository.MaterielRepository;

public class VideoProjecteurService {

	@Autowired
	private MaterielRepository materielRepository;
	
	
	public void createVideoProjecteur(VideoProjecteur videoProjecteur) {
		if (videoProjecteur != null) {
			materielRepository.save(videoProjecteur);
		}
	}

	public void deleteVideoProjecteurById(Integer id) {
		materielRepository.deleteById(id);
		
	}

	public void deleteAllVideoProjecteur() {
		List<VideoProjecteur> videoProjecteurs = materielRepository.findAllVideoProjecteur();
		for (VideoProjecteur videoProjecteur : videoProjecteurs) {
			deleteVideoProjecteurById(videoProjecteur.getId());
		}
	}
	
	public void deleteVideoProjecteur(VideoProjecteur videoProjecteur) {
		deleteVideoProjecteurById(videoProjecteur.getId());
	}

	public List<VideoProjecteur> showAllVideoProjecteur() {
		List<VideoProjecteur> videoProjecteurs = materielRepository.findAllVideoProjecteur();
		return videoProjecteurs;
	}
	
	public VideoProjecteur showVideoProjecteurById(Integer id) {
		Optional<VideoProjecteur> opt = materielRepository.findVideoProjecteurById(id);
		VideoProjecteur videoProjecteur = null;
		if (opt.isPresent()) {
			videoProjecteur = opt.get();
		}
		return videoProjecteur;
	}
	
	
	public List<VideoProjecteur> showVideoProjecteur(){
		List<VideoProjecteur> videoProjecteur = materielRepository.findAllVideoProjecteur();
		return videoProjecteur;
	}
	
	
	public void modifVideoProjecteur(VideoProjecteur videoProjecteur) {
		List<VideoProjecteur> videoProjecteurs = materielRepository.findAllVideoProjecteur();
		for(VideoProjecteur vp : videoProjecteurs) {
			if(vp.getId().equals(vp.getId())) {
				materielRepository.save(vp);
			}
		}
	}
	
}
