package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Certificat;
import tn.esprit.spring.entities.Complaint;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repositories.ComplaintRepository;
import tn.esprit.spring.repositories.UserRepository;
import tn.esprit.spring.services.IComplaintService;

@Service
public class ComplaintService implements IComplaintService{
	@Autowired
	ComplaintRepository cr;
	@Autowired
	UserRepository ur;
	@Override
	public void addComplaint(Complaint c) {
		cr.save(c);
	}
	@Override
	public void deleteComplaint(Long idC) {
		cr.deleteById(idC);
		
	}
	@Override
	public List<Complaint> findComplaints() {
		return cr.findAll();
	}
	@Override
	public Complaint updateComplaint(Complaint c) {
		return cr.save(c);
	}
		@Override
		public void affecterComplainttoUser(Long idUser, Long idC) {
			User user = ur.findById(idUser).orElse(null);
			System.out.print(user);
			Complaint c = cr.findById(idC).orElse(null);
			c.setUser(user);
			cr.save(c);
			
		
	}}