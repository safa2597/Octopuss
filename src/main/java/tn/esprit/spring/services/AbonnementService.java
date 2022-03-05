package tn.esprit.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Abonnement;
import tn.esprit.spring.iservices.IAbonnementService;
import tn.esprit.spring.repositories.AbonnementRepository;
import tn.esprit.spring.repositories.UserRepository;



@Service
public class AbonnementService implements IAbonnementService {


	@Autowired
	AbonnementRepository ar;
	@Autowired
	UserRepository ur;
	
	@Override
	public Abonnement ajouterabonnement(Abonnement abonnement) {
		
		ar.save(abonnement);
		return abonnement;
	}

	@Override
	public Abonnement modifierabonnement(Abonnement abonnement, Long id) {

		if(id==1)
		{
			Optional<Abonnement> Abonnements = ar.findById(id);

			if(Abonnements!=null)
				ar.save(abonnement);
		}
		return abonnement;
		
				}

	@Override
	public void supprimerabonnement(Long id) {

		ar.deleteById(id);
	}

	@Override
	public List<Abonnement> afficherabonnement() {
		return (List<Abonnement>) ar.findAll();
	}

	/*@Override
	public void affecterAbonnementtoUser(Abonnement abonnement, Long idUsers) {
		
		User usr = ur.findById(idUsers).get();	
		usr.setAbonnements(abonnement);
		ar.save(abonnement);
	}

	*/

	
	
}
