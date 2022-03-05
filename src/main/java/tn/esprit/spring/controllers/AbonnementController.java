package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Abonnement;
import tn.esprit.spring.iservices.IAbonnementService;




@RestController
public class AbonnementController {
	
	@Autowired
	IAbonnementService as;

	@PostMapping("/add-Abonnement")
	public Abonnement addAbonnement(@RequestBody Abonnement a) {
	Abonnement Abonnement = as.ajouterabonnement(a);
	return Abonnement;
	}
	@DeleteMapping("/remove-Abonnement/{Abonnement-id}")
	public void removeAbonnement(@PathVariable("Abonnement-id") Long idabn) {
	as.supprimerabonnement(idabn);
	}
	@PutMapping("/modify-Abonnement/{Abonnement-id}")
	public Abonnement modifyAbonnement(@RequestBody Abonnement Abonnement,@PathVariable("Abonnement-id") Long idabn) {
	return as.modifierabonnement(Abonnement, idabn);
	}
	@GetMapping("/retrieve-all-Abonnements")
	public List<Abonnement> getAbonnements() {
	List<Abonnement> listAbonnements = as.afficherabonnement();
	return listAbonnements;
	}
	
	/*@PostMapping("/ajoutaffec_abon")
	public void ajouterEtAffecterAbonUsers(@RequestBody Abonnement abonnement, @RequestParam("idusers") Long idUsers)
	{
		as.affecterAbonnementtoUser(abonnement, idUsers);
		}*/
}
