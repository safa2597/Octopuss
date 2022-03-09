package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Moneypot;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repositories.MoneypotRepository;
import tn.esprit.spring.repositories.UserRepository;

@Service
public class MoneypotService implements IMoneypotService {
	@Autowired
	MoneypotRepository mpr;
	@Autowired
	UserRepository ur;

	@Override
	public Moneypot addMoneypot(Moneypot mp) {
		// TODO Auto-generated method stub
		return mpr.save(mp);
	}

	@Override
	public Moneypot updateMoneypot(Moneypot mp) {
		// TODO Auto-generated method stub
		return mpr.save(mp);
	}

	@Override
	public List<Moneypot> findMoneypots() {
		// TODO Auto-generated method stub
		return (List<Moneypot>) mpr.findAll();
	}

	@Override
	public void deleteMoneypot(Long idMoneypot) {
		mpr.deleteById(idMoneypot);;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMoneypot(Moneypot mp) {
		mpr.delete(mp);
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void ajouterMoneypotEtAffecterAuser(long idJack , long id ) {
		User u = ur.findById(id).get();
		Moneypot m = mpr.findById(idJack).get();
		u.getMoneypots().add(m);
		
		
		
	}
	
	@Transactional
	@Override
	public float ajouterMontant(Long id, Long idJack, float money){
		User u = ur.findById(id).get();
		Moneypot m= mpr.findById(idJack).get();
		u.getMoneypots().add(m);
		float mc=m.getMoneyCollected()+money;
		m.setMoneyCollected(mc);
		mpr.save(m);
		return mc;
	}
}
