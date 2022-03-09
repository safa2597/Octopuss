package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Complaint;
import tn.esprit.spring.entities.Oppointment;

public interface IOppointmentService {

	public void addOppointment(Oppointment o);

	public void deleteOppointment(Long idOp);
	
	public Oppointment updateOppointment(Oppointment o);

	List<Oppointment> findOppointments();

}
