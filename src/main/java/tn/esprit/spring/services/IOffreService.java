package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Offre;

public interface IOffreService {
	
	//List<Offre> selectOffre();

	void addOffre(Offre offre);
	public void deleteOffre(Long idOffre);
	List<Offre> getAllVisiteurs();
	void editOffre(Offre offre);
}
