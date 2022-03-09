package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Complaint;
import tn.esprit.spring.entities.Oppointment;
import tn.esprit.spring.repositories.OppointmentRepository;

@Service
public class OppointmentService implements IOppointmentService{
	@Autowired
	OppointmentRepository or;
	
	@Override
	public void addOppointment(Oppointment o) {
		or.save(o);
	}

	@Override
	public void deleteOppointment(Long idOp) {
		or.deleteById(idOp);
		
	}

	@Override
	public List<Oppointment> findOppointments() {
		return or.findAll();
	}

	@Override
	public Oppointment updateOppointment(Oppointment o) {
		return or.save(o);
	}

}
