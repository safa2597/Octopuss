package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Moneypot;



public interface IMoneypotService {
	public Moneypot addMoneypot(Moneypot mp);
	public Moneypot updateMoneypot(Moneypot mp);
	public List<Moneypot> findMoneypots();
	public void deleteMoneypot (Long idMoneypot);
	public void deleteMoneypot(Moneypot mp);
	public void ajouterMoneypotEtAffecterAuser(long idJack , long id );
	public float ajouterMontant(Long id, Long idJack, float money);


}
