package tn.esprit.spring.iservices;

import java.util.List;

import tn.esprit.spring.entities.Abonnement;



public interface IAbonnementService {

	
	public Abonnement ajouterabonnement(Abonnement abonnement);
	public Abonnement modifierabonnement(Abonnement abonnement,Long id);
	public void supprimerabonnement(Long id);
	public List<Abonnement> afficherabonnement();
	//public void affecterAbonnementtoUser(Abonnement abonnement,Long idUsers);

	
}
