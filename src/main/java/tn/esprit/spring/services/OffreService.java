package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Offre;
import tn.esprit.spring.repositories.OfffreRepository;


@Service
public class OffreService implements IOffreService {
	@Autowired
	OfffreRepository or;

	@Override
	public void addOffre(Offre offre) {
		or.save(offre);
		
	}

	@Override
	public void deleteOffre(Long idOffre) {
		or.deleteById(idOffre);
		
	}

	@Override
	public List<Offre> getAllVisiteurs() {
		return (List<Offre>) or.findAll();
		
	}

	@Override
	public void editOffre(Offre offre) {
		or.save(offre);
		
	}

	
}
		