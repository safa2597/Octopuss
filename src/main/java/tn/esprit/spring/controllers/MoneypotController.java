package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Moneypot;
import tn.esprit.spring.services.IMoneypotService;
@RestController

public class MoneypotController {
	@Autowired
	IMoneypotService mps;

	@PostMapping("ajouterMoneypot")
	public Moneypot ajouterMoneypot(@RequestBody Moneypot mp) {
		return mps.addMoneypot(mp);
	}
	@PutMapping("modifierMoneypot")
	public Moneypot modifierMoneypot(@RequestBody Moneypot mp) {
		return mps.updateMoneypot(mp);
	}
	@DeleteMapping("supprimerMoneypot")
	public void supprimerMoneypot(@PathVariable("idMoneypot") Long idMoneypot) {
		mps.deleteMoneypot(idMoneypot);
		
	}
	@GetMapping("listerMoneypot")
	public List<Moneypot> getMoneypots() {
	List<Moneypot> listMoneypots = mps.findMoneypots();
		return listMoneypots;
	}
	

	@PutMapping("/affectUserMoneypot/{id-user}/{id-moneypot}")
	public void affecterUserMoneypot(@PathVariable("id-user") Long idUser,@PathVariable("id-moneypot") Long idMoneypot){
		mps.ajouterMoneypotEtAffecterAuser(idMoneypot, idUser);
	}
	@PutMapping("/participer-a-Moneypot/{id}/{id-Jack}/{money}")
	public float ParticiperAMoneypot(@PathVariable("id") Long id, @PathVariable("id-Jack")Long idJack, @PathVariable("money")float money){
		return mps.ajouterMontant(id, idJack,money);
	}
}
